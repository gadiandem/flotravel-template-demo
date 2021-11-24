package com.flocash.flotravel.demo.service;

import com.flocash.flotravel.demo.dto.common.AuthBasic;
import org.springframework.web.reactive.function.client.WebClient;

public interface WebClientService {

	WebClient requestDefault();
	WebClient retRequestWithEndpoint(String endpoint);
	WebClient requestAuthBasic(String endpoint, AuthBasic authBasic);
}
