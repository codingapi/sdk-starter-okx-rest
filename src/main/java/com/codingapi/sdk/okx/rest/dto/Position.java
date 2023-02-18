package com.codingapi.sdk.okx.rest.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Position {

    private final int lever;
    private final float posUsdt;
    private final float upl;
    private final float uplRatio;
    private final float avgPx;
    private final float margin;
    private final float mgnRatio;
    private final float liqPx;
    private final float markPx;

    public Position(int lever, float posUsdt,
                    float upl, float uplRatio,
                    float avgPx, float margin,
                    float mgnRatio, float liqPx,
                    float markPx) {
        this.lever = lever;
        this.posUsdt = posUsdt;
        this.upl = upl;
        this.uplRatio = uplRatio;
        this.avgPx = avgPx;
        this.margin = margin;
        this.mgnRatio = mgnRatio;
        this.liqPx = liqPx;
        this.markPx = markPx;
    }

    public void print(){
        System.out.println("杠杆倍数:"+lever);
        System.out.println("持仓数量(USDT):"+posUsdt);
        System.out.println("未实现收益(USDT):"+upl);
        System.out.println("未实现收益率(%):"+uplRatio);
        System.out.println("开仓平均价:"+avgPx);
        System.out.println("保证金余额(USDT):"+margin);
        System.out.println("保证金率(%):"+mgnRatio);
        System.out.println("预估强平价(USDT):"+liqPx);
        System.out.println("标记价格(USDT):"+markPx);
    }
}
