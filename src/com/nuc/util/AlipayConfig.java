package com.nuc.util;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016100200644445";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCyNT8c4WEvxw84r13s2oW5PkP4Pk/0LxkmWUQ4W/8gITnfaS0nITnATYA4mPH35VytIV5v5umKVRgpRa6bwwfBTKVCdPfsDgB7OLM89JKqhtQPJNfU1ItGz/VnhTef+lm61YLrZm/ztqgZgTPlTlqKhOrsULXVC4aKWTI6z1/3p2RSm3AjlT667kXn7qAMicLks+KBYlnGzo8CvKXQGZSDEetkUmjqiBUX5yuobbRQI6tX+4SSuPldYKElouLwt9dMXLy63UsT7imteI+t8IuSTdzj7mqFFrrfcQJKtAM8GpKKguqp93f8hSOPJp8OCwaGyAU893y8KV8jeG5NrGvVAgMBAAECggEAOzisr5lKZck+CrVkfjikZcoGZnG2ukwIjJDvtdcEspW4GMFoCu/ktD5NFQHmr13ebX6AVqmjBKCAtf59JzAp3Jfu92XNmfmROWG/VstkDh1eTWYN/6FeY3rqb6t6r8RPm2Im7rmNDK2vsUIZj+N4/T1soHm144XAASvhIGAX4UGGCEmE76hnUNJjd+BDR3nPRk/QIKvZHhDIfVt/xbHVjj1aG5tFoxKgbZgc1lc1qOIP5oQ8IWAQy9ZlvsjvEfhqc4ZveaV4QKJsExoZMtwM1+p/mZkQhAxB+bkt1Z3WrJ5P/CwY5L1/YKzmi6Fg3NoVETmjd6hu/sZ+lWHZHeQ0hQKBgQDn93vQNx/HsIq4Og1XYzFi3lqaTooeOHjEgX5hd1xX9lSBFYB4PpD29YTh0d93IHsTaKLfM4tZmb+UxQQQURX7kJttdX/Zcor2h+8xc2yeQFAfPE0VXbGFNKfdB/VSu2kzGP80lFa4sOkoXPgajlIEUMzJcdED0JBBXSu6jC4FDwKBgQDEq+fD1NcWAUhcq/2fOWsaVM8CZSFlD9vF/U++iyWZ7RqZs8lJNsI3gnJXBXGL4Y22sIRmcW45d2Y15FguJRAfLly9F3zybDDS3B3GsNgpsQWWNKz63d+81+vEgCRlsSsYQLiI8wet9JyE86wnruHVMA+Devx0TGDg+2mxy8Bo2wKBgQDiO5dwmeKP0hlo1Y1fdimbYHsC1aiVEsSN+jF1A4F3dJI0FvFl1LdzdD62Mwb72xzN8BYxE8dLisyzXna5JywGXqGH3rnjLHhlOmxJUWZU7Sp3XEtdlDRnUtSImJNlrcxK/o0gDbCKjlfHeuyqkbVh6h/gM/YC/21BooncdY0IdwKBgHO8kjRdQYHymUnn8OXNnWiude/74Y4eqf+2lUIVkrglnxzKf261ac/O1Ui+rFZcEtBqyk+a+vmYeS7HxNjK+NTQrMSeWOo0nvrHjEJL+bl3Mkl1kEJFZZA1JMrLeh/aBflMxQvasS8+nwlieHIV6VJS6R4/tucdt3lOmqGFvSI3AoGBALb496WhNm8+lYs6bBM6qUGsNY/U5U7bg9vYRXqzfObDJtuQ+l46Y1rfYEo9tjOZ1LObwWyr9WgcoJSmNGw9l3Wft5Boxj2bqzya9YeTo5BJvq+eOUQpOKprbDSpBCna7kkPltuB8AlCT9zvyA2ptYZ2OSrVZXcVMCIQq+L4ayr5";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAwiM2EpCygM+gXM42YNA6d1WKjdfPSVjy+VkSvoG9s7Kn7lzgsaTnBHwgzVyLoCUBICQ3iMhhUmk6/8pQs5RAW2HVGjPqdJBpSizWvrUs9Jpjuzb8sZIfmvU35VU6Bk2aEy8x41vO/tyK6UY42P3MA7fCZVt4KN3FK9FQkTvI/2WBSVAy/BmBqcc+YbrJ7vPkzpLD0faSe9M49E3IH5qQAVIsout9iw2fZIbKlLXfFhG1Ji57y59QrCg4PMHRrACwWcbw5xR44dkuP/gXiI5ZdT+KJot/Y7vq2kp5nygPuzepxy+H84PBxIRWM4OBMCA5nkka+VZfFBHrBO0NF0qreQIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost:8080/TestPro_war_exploded/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost:8080/TestPro_war_exploded/UserServlet?opr=add";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "G:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

