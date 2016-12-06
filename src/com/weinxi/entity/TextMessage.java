package com.weinxi.entity;

import java.io.Serializable;

import com.weinxi.common.CommonWeChatAttributes.MsgType;

/**
 * 微信消息之文本消息
 * 
 */
public class TextMessage implements Serializable {

	private static final long serialVersionUID = 2016653786257150388L;

	// 开发者微信号
	private String ToUserName;

	// 发送方帐号（一个OpenID）
	private String FromUserName;

	// 消息创建时间 （整型）
	private long CreateTime;

	// 消息类型
	private MsgType MsgType;

	// 消息内容
	private String Content;

	public String getToUserName() {
		return ToUserName;
	}

	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}

	public String getFromUserName() {
		return FromUserName;
	}

	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}

	public long getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(long createTime) {
		CreateTime = createTime;
	}

	public MsgType getMsgType() {
		return MsgType;
	}

	public void setMsgType(MsgType msgType) {
		MsgType = msgType;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}
}
