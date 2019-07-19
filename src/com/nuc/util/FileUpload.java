package com.nuc.util;


import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class FileUpload {

    public static String getFileUpload(String uploadFilePath, HttpServletRequest request){
        String path_ans = "";
        String uploadFileName=""; //上传的文件名
        String fieldName=""; //表单字段元素的name属性值
        boolean isMultipart= ServletFileUpload.isMultipartContent(request);
        //上传文件的存储路径
        //创建临时文件目录路径
        File tempPatchFile=new File("d:\\FindImg");
        if (!tempPatchFile.exists()){  //判断文件或目录是否存在
            tempPatchFile.mkdirs();   //创建指定的目录，
        }
        if (isMultipart){
            DiskFileItemFactory factory=new DiskFileItemFactory();
            factory.setSizeThreshold(4096); //设置缓冲区大小4Kb
            factory.setRepository(tempPatchFile);  //设置上传文件的临时文件存放路径
            ServletFileUpload upload=new ServletFileUpload(factory);
            //upload.setSizeMax(1024*30); //设置单个文件的最大限制
            try {
                List<FileItem> items=upload.parseRequest(request);
                Iterator<FileItem> iter=items.iterator();
                while (iter.hasNext()){  //依次处理每个表单元素
                    FileItem item=iter.next();
                    if (item.isFormField()){ //普通表单字段
                        fieldName=item.getFieldName();//表单字段的name属性
                        if(fieldName.equals("user")){
                            //输出表单字段的值
                            // System.out.println(item.getString("utf-8")+"上传了文件！");
                        }
                    }else {  //文件表单字段
                        String fileName=item.getName();
                        System.out.println(fieldName+"@@@");
                        List<String> filType= Arrays.asList("gif","bmp","jpg");
                        String ext=fileName.substring(fileName.lastIndexOf(".")+1);
                        System.out.println(ext+"####");
                        if (!filType.contains(ext)){
                            //System.out.println("上传失败，文件类型只能是gif,bmp,jpg");
                        }else {
                            if (fileName!=null&&!fileName.equals("")){
                                File fullFile=new File(item.getName());
                                System.out.println(fullFile.getName());
                                File saveFile=new File(uploadFilePath,fullFile.getName());
                                path_ans = saveFile.getPath();
                                System.out.println(path_ans+":@@@@");
                                item.write(saveFile);
                                uploadFileName=fullFile.getName();
                                //System.out.println("上传成功后的文件名是："+uploadFileName);
                            }
                        }
                    }
                }
            }catch (FileUploadBase.SizeLimitExceededException ex){
                //System.out.println("上传失败，文件太大，单个文件的最大限制是："+upload.getSizeMax()+"bytes!");
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        return  path_ans;
    }

}