package com.example.fan.beihang;


import java.io.Serializable;
import java.util.List;

    /**
     * Auto-generated: 2019-01-23 17:26:56
     *
     * @author www.jsons.cn
     * @website http://www.jsons.cn/json2java/
     */
    public class JsonsRootBean implements Serializable{

        private int code;
        private String message;
        private List<Data> data;
        public void setCode(int code) {
            this.code = code;
        }
        public int getCode() {
            return code;
        }

        public void setMessage(String message) {
            this.message = message;
        }
        public String getMessage() {
            return message;
        }

        public void setData(List<Data> data) {
            this.data = data;
        }
        public List<Data> getData() {
            return data;
        }

    }

