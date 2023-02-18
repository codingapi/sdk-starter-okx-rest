package com.codingapi.sdk.okx.rest.convert;


import com.codingapi.sdk.okx.rest.dto.Position;
import com.codingapi.sdk.okx.rest.protocol.account.Positions;

public class PositionConvertor {

    public  static Positions.Data getData(Positions.Response response,String instId){
        if(response.isSuccess()){
            for(Positions.Data data:response.getData()){
                if(data.getInstId().equals(instId)){
                    return data;
                }
            }
        }
        return null;
    }

    public Position convert(Positions.Response response,String instId){
        Positions.Data data = getData(response,instId);
        if(data!=null){
            return new Position(
                    Integer.parseInt(data.getLever()),
                    getPosUsdt(data),
                    Float.parseFloat(data.getUpl()),
                    getUplRatioValue(data),
                    Float.parseFloat(data.getAvgPx()),
                    Float.parseFloat(data.getMargin()),
                    Float.parseFloat(data.getMgnRatio()),
                    Float.parseFloat(data.getLiqPx()),
                    Float.parseFloat(data.getMarkPx())
            );
        }
        return null;
    }


    private static float getPosUsdt(Positions.Data position){
        return (float) (Float.parseFloat(position.getLast())/100.0/Float.parseFloat(position.getLever()) * Float.parseFloat(position.getPos()));
    }

    private static float getUplRatioValue(Positions.Data position){
        return (float) (Float.parseFloat(position.getUplRatio()) * 100.0);
    }

    private static float getMgnRatioValue(Positions.Data position){
        return (float) (Float.parseFloat(position.getMgnRatio()) * 100.0);
    }

}
