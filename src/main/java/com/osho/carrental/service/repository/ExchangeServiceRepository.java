package com.osho.carrental.service.repository;

import com.osho.carrental.valueobject.ResponseTemplateVO;
import org.json.JSONException;

import java.io.IOException;

public interface ExchangeServiceRepository {

//    ResponseTemplateVO getExchangeService(int orderId); // DISABLED 221224

    ResponseTemplateVO getExchangeWithoutMicroservice(int orderId) throws JSONException, IOException;
}
