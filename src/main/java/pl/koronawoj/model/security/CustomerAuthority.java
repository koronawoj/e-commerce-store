package pl.koronawoj.model.security;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by z00382545 on 10/20/16.
 */
public class CustomerAuthority implements GrantedAuthority{

	private static final long serialVersionUID = 1L;
	private final String authority;

    public CustomerAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority;
    }
}
