package com.codingapi.sdk.okx.rest.protocol.market;

import com.codingapi.sdk.okx.rest.protocol.OkxResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

public class Books {

    @Setter
    @Getter
    public static class Response extends OkxResponse {

        public List<Data> getData() {
            return getMultiData(Data.class);
        }

        public List<Book> getBuyBooks(){
            Data  data = getData().get(0);
            List<Book> list = new ArrayList<>();
            for(List<String> item:data.getBids()){
                Book book = new Book();
                book.setPrice(Float.parseFloat(item.get(0)));
                book.setInstSize(Float.parseFloat(item.get(1)));
                book.setOrderSize(Integer.parseInt(item.get(3)));
                list.add(book);
            }
            return list;
        }

        public List<Book> getSellBooks(){
            Data  data = getData().get(0);
            List<Book> list = new ArrayList<>();
            for(List<String> item:data.getAsks()){
                Book book = new Book();
                book.setPrice(Float.parseFloat(item.get(0)));
                book.setInstSize(Float.parseFloat(item.get(1)));
                book.setOrderSize(Integer.parseInt(item.get(3)));
                list.add(book);
            }
            return list;
        }

    }


    @Setter
    @Getter
    @ToString
    public static class Book{
        /**
         * 价格
         */
        private float price;

        /**
         * 交易量
         */
        private float instSize;

        /**
         * 订单数量
         */
        private int orderSize;
    }




    @Getter
    @Setter
    @ToString
    public static class Data{
        /**
         * 卖方深度
         */
        private List<List<String>> asks;

        /**
         * 买方深度
         */
        private List<List<String>> bids;

        /**
         * 深度产生的时间
         */
        private String ts;

    }


}
