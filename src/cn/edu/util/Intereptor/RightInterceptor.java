package cn.edu.util.Intereptor;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import cn.edu.right.bean.Right;

public class RightInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public String intercept(ActionInvocation invocation) throws Exception {
		String actionName = invocation.getProxy().getActionName();
		if (actionName.equals("manger_login") || actionName.equals("manger_toIndexPage"))
			return invocation.invoke();
		else {
			Map<String, Object> session = invocation.getInvocationContext().getSession();
			Map<String, Object> parameters = invocation.getInvocationContext().getParameters();

			if (actionName.contains("toEditPage")) {
				if (parameters.get("form.id") != null) {
					actionName = actionName + "?type=update";
				} else {
					actionName = actionName + "?type=save";
				}
			}

			if (session.get("currentManger") == null) {
				return "login";
			}
			List<Right> allRight = (List<Right>) session.get("allRight");
			Set<Right> rights = (Set<Right>) session.get("rights");
			boolean flag = false;
			boolean sign = false;
			for (Right right : allRight) {
				if (right.getUrl().equals(actionName)) {
					flag = true;
				}
			}

			if (flag) {
				// System.out.println(actionName);
				for (Right right : rights) {
					// System.out.println(right.getUrl());
					if (actionName.equals(right.getUrl()))
						sign = true;
				}
				if (sign)
					return invocation.invoke();
				else
					return "noRight";
			} else {
				return invocation.invoke();
			}
		}

	}
}
