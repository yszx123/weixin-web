package com.weinxi.test;

import java.text.MessageFormat;

import com.weinxi.common.CommonWeChatAttributes;
import com.weinxi.entity.AccessTokenTemp;
import com.weinxi.entity.TotalMember;
import com.weinxi.entity.template.OrdersTemplate;
import com.weinxi.entity.template.TemplateContent;
import com.weinxi.entity.template.TemplateData;
import com.weinxi.entity.template.TemplateDate;
import com.weinxi.entity.template.TemplateFirst;
import com.weinxi.entity.template.TemplateRemark;
import com.weinxi.entity.template.TemplateUser;
import com.weinxi.util.GetAccessTokenUtil;
import com.weinxi.util.HttpUtils;
import com.weinxi.util.JsonUtils;

public class WeiXinSendMessageTest {

	private static final String APPID = "";

	private static final String SECRET = "";

	private static final String TEMPLATEID = "";

	private static String accessToken;

	public static void main(String[] args) {
		initAccessToken();
		sendTemplateMsg();
	}

	private static void sendTemplateMsg() {
		OrdersTemplate ordersTemplate = new OrdersTemplate();
		ordersTemplate.setTouser(getUserOpenId());
		ordersTemplate.setUrl("http://www.baidu.com");
		ordersTemplate.setTemplate_id(TEMPLATEID);
		ordersTemplate.setTopcolor("#173177");

		TemplateData data = new TemplateData();
		data.setFirst(new TemplateFirst("收到一个新的预约咨询", "#173177"));
		data.setDay(new TemplateDate("15:30", "#173177"));
		data.setUser(new TemplateUser("sky", "#173177"));
		data.setContent(new TemplateContent("牙齿好疼啊？", "#173177"));
		data.setRemark(new TemplateRemark("赶紧处理吧，哈哈！", "#173177"));
		ordersTemplate.setData(data);

		String json = JsonUtils.toJson(ordersTemplate);
		System.out.println(json);
		String url = MessageFormat.format(CommonWeChatAttributes.SEND_TEMPLATE_MSG, accessToken);
		String result = GetAccessTokenUtil.httpRequest(url, "POST", json);
		System.out.println(result);
	}

	private static String getUserOpenId() {
		String getUserUrl = MessageFormat.format(CommonWeChatAttributes.GET_ALL_USER, accessToken);
		String resultUser = HttpUtils.getRequest(getUserUrl, "GBK");
		TotalMember totalMember = JsonUtils.toObject(resultUser, TotalMember.class);
		return totalMember.getData().getOpenid().get(0);
	}

	private static void initAccessToken() {
		AccessTokenTemp temp = GetAccessTokenUtil.getAccessToken(APPID, SECRET);
		if (temp != null) {
			accessToken = temp.getAccess_token();
		}
	}
	
}
