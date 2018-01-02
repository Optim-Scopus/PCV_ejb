/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tcc.pcv_ejb.proxyWs;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import javax.xml.namespace.QName;

/**
 *
 * @author luiz
 */
public class RegressorWsProxy {

    private final static QName REGRESSORWS_QNAME = new QName("http://ws.regressao.tcc.com/", "RegressorWS");

    private static final String SERVICE_PATH = "RegressorWS/RegressorWS?WSDL";
    private RegressorWS regressorWs;
    
    private RegressorWS getRegressorWs(){
        if (regressorWs == null) {
            try {
                URL url = new URL("http://localhost:8080/" + SERVICE_PATH);
                RegressorWS_Service service = new RegressorWS_Service(url, REGRESSORWS_QNAME);
                regressorWs = service.getRegressorWSPort();

            } catch (MalformedURLException ex) {
                regressorWs = null;
            }
        }
        return regressorWs;
    }

    public List<Double> getThetaAsVectorForRestaurant(Long id) {
        return getRegressorWs().getThetaAsVectorForRestaurant(id);
    }
    
    public List<Double> getThetaAsVectorForBank(Long id) {
        return getRegressorWs().getThetaAsVectorForBank(id);
    }
    
    public List<Double> getThetaAsVectorForGrocery(Long id) {
        return getRegressorWs().getThetaAsVectorForGrocery(id);
    }
    
}
