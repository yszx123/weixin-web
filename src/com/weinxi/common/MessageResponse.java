package com.weinxi.common;

import java.util.Date;

import com.weinxi.common.CommonWeChatAttributes.MsgType;
import com.weinxi.entity.TextMessage;
import com.weinxi.util.MessageUtil;

/**
 * 
 * 
 * @author jiangyin
 */
public class MessageResponse {
	
	/**
	 * 回复文本消息
	 * @param fromUserName
	 * @param toUserName
	 * @param respContent
	 * @return
	 */
	public static String getTextMessage(String fromUserName , String toUserName , String respContent) {
		
		TextMessage textMessage = new TextMessage();
		textMessage.setToUserName(toUserName);
		textMessage.setFromUserName(fromUserName);
		textMessage.setCreateTime(new Date().getTime());
		textMessage.setMsgType(MsgType.TEXT);
		textMessage.setContent(respContent);
		return MessageUtil.textMessageToXml(textMessage);
	}
}