package com.codingapi.sdk.okx.rest.dto.system;

import com.codingapi.sdk.okx.rest.dto.OkxResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

public class Status {


    @ToString
    public enum Request{
        scheduled,ongoing,pre_open,completed,canceled
    }


    @Setter
    @Getter
    @ToString
    public static class Data {
        /**
         * 系统维护说明的标题
         */
        private String title;
        /**
         * 系统维护的状态
         */
        private String state;
        /**
         * 系统维护的开始时间,Unix时间戳的毫秒数格式 如：1617788463867
         */
        private String begin;
        /**
         * 交易全面开放的时间，Unix时间戳的毫秒数格式 如：1617788463867
         * 在维护完成前，是预期结束时间；维护完成后，会变更为实际结束时间。
         */
        private String end;
        /**
         * 预开放开始的时间，开放撤单、Post Only 下单和资金转入功能的时间
         */
        private String preOpenBegin;
        /**
         * 系统维护详情的超级链接,若无返回值，默认值为空，如： “”
         */
        private String href;
        /**
         * 服务类型， 0：WebSocket ; 5：交易服务；6：大宗交易；7：策略交易；99：其他（如：停止部分产品交易）
         */
        private String serviceType;
        /**
         * 系统，unified：交易账户
         */
        private String system;
        /**
         * 改期进度说明，如： 由 2021-01-26T16:30:00.000Z 改期到 2021-01-28T16:30:00.000Z
         */
        private String scheDesc;

    }

    @ToString
    public static class Response extends OkxResponse {

        public List<Data> getData() {
            return getMultiData(Data.class);
        }
    }
}
