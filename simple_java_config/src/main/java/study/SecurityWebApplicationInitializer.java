package study;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {
	public SecurityWebApplicationInitializer() {	//���� ������ ������ ���� ��� �����ڷ� ���� ������ ���־�� �Ѵ�.
		super(SecurityConfig.class);
	}
}
