package com.weinxi.common;       
import com.weinxi.entity.AccessTokenTemp;
    
/**  
 * 定时获取微信access_token的线程  
 *   
 * @author liuyq  
 * @date 2013-05-02  
 */    
public class TokenThread implements Runnable {   
    public static AccessTokenTemp accessTokenTemp = null;    
    
    public void run() {    
//        while (true) {    
//            try {    
//            	accessTokenTemp = GetAccessTokenUtil.getAccessToken(CommonWeChatAttributes.APPID, CommonWeChatAttributes.APPSECRET);   
//                if (null != accessTokenTemp) {
//                	Setting setting = SettingUtils.get();
//                	setting.setAccess_token(accessTokenTemp.getAccess_token());
//                	SettingUtils.set(setting);
//                    // 休眠7000秒    
//                    Thread.sleep((accessTokenTemp.getExpires_in() - 200) * 1000);    
//                } else {    
//                    // 如果access_token为null，60秒后再获取    
//                    Thread.sleep(60 * 1000);    
//                }    
//            } catch (InterruptedException e) {    
//                try {    
//                    Thread.sleep(60 * 1000);    
//                } catch (InterruptedException e1) {    
//                        
//                }    
//            }    
//        }    
    }    
}    