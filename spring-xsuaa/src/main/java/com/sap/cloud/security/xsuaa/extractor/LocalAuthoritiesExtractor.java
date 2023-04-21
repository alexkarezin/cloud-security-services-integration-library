/**
 * SPDX-FileCopyrightText: 2018-2023 SAP SE or an SAP affiliate company and Cloud Security Client Java contributors
 * <p>
 * SPDX-License-Identifier: Apache-2.0
 */
package com.sap.cloud.security.xsuaa.extractor;

import com.sap.cloud.security.xsuaa.token.XsuaaToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LocalAuthoritiesExtractor implements AuthoritiesExtractor {

	protected final String appId;

	public LocalAuthoritiesExtractor(String appId) {
		this.appId = appId;
	}

	@Override
	public Collection<GrantedAuthority> getAuthorities(XsuaaToken jwt) {

		Set<String> scopeAuthorities = new HashSet<>(getScopes(jwt, appId));

		Stream<String> authorities = Stream.of(scopeAuthorities).flatMap(Collection::stream);

		return authorities.map(SimpleGrantedAuthority::new).collect(Collectors.toList());
	}

	protected Set<String> getScopes(XsuaaToken jwt, String appId) {
		Collection<String> scopes = jwt.getScopes();
		if (scopes == null) {
			return Collections.emptySet();
		}
		return scopes.stream()
				.filter(scope -> scope.startsWith(appId + "."))
				.map(scope -> scope.substring(appId.length() + 1))
				.collect(Collectors.toSet());
	}

}
