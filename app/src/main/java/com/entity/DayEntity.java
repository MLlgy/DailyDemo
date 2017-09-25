package com.entity;

import java.util.List;

/**
 * Created by liguoying on 2017/9/22.
 */

public class DayEntity {


    @Override
    public String toString() {
        return "DayEntity{" +
                "code='" + code + '\'' +
                ", content=" + content +
                '}';
    }

    /**
     * code : ok
     * content : [{"name":"今天","date":[{"id":0,"status":1,"title":"中间","image":"haha"},{"id":1,"status":1,"title":" 中间 ","image":"haha"},{"id":2,"status":1,"title":" 中间 ","image":"haha"},{"id":21,"status":1,"title":" 中间 ","image":"haha"},{"id":22,"status":1,"title":" 中间 ","image":"haha"}]},{"name":"明天","date":[{"id":3,"status":1,"title":"中间","image":"haha"},{"id":4,"status":1,"title":"中间","image":"haha"},{"id":5,"status":1,"title":"中间","image":"haha"}]},{"name":"明天","date":[{"id":6,"status":1,"title":"中间","image":"haha"},{"id":0,"status":1,"title":"中间","image":"haha"},{"id":7,"status":1,"title":"中间","image":"haha"},{"id":23,"status":1,"title":" 中间 ","image":"haha"}]},{"name":"明天","date":[{"id":8,"status":1,"title":"中间","image":"haha"},{"id":9,"status":1,"title":"中间","image":"haha"},{"id":11,"status":1,"title":"中间","image":"haha"},{"id":24,"status":1,"title":" 中间 ","image":"haha"},{"id":25,"status":1,"title":" 中间 ","image":"haha"},{"id":26,"status":1,"title":" 中间 ","image":"haha"}]},{"name":"明天","date":[{"id":12,"status":1,"title":"中间","image":"haha"},{"id":13,"status":1,"title":"中间","image":"haha"},{"id":14,"status":1,"title":"中间","image":"haha"}]},{"name":"明天","date":[{"id":15,"status":1,"title":"中间","image":"haha"},{"id":16,"status":1,"title":"中间","image":"haha"},{"id":17,"status":1,"title":"中间","image":"haha"}]},{"name":"明天","date":[{"id":18,"status":1,"title":"中间","image":"haha"},{"id":19,"status":1,"title":"中间","image":"haha"},{"id":20,"status":1,"title":"中间","image":"haha"}]}]
     */

    private String code;
    private List<ContentBean> content;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<ContentBean> getContent() {
        return content;
    }

    public void setContent(List<ContentBean> content) {
        this.content = content;
    }

    public static class ContentBean {

        @Override
        public String toString() {
            return "ContentBean{" +
                    "name='" + name + '\'' +
                    ", date=" + date +
                    '}';
        }

        /**
         * name : 今天
         * date : [{"id":0,"status":1,"title":"中间","image":"haha"},{"id":1,"status":1,"title":" 中间 ","image":"haha"},{"id":2,"status":1,"title":" 中间 ","image":"haha"},{"id":21,"status":1,"title":" 中间 ","image":"haha"},{"id":22,"status":1,"title":" 中间 ","image":"haha"}]
         */

        private String name;
        private List<DateBean> date;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<DateBean> getDate() {
            return date;
        }

        public void setDate(List<DateBean> date) {
            this.date = date;
        }

        public static class DateBean {
            @Override
            public String toString() {
                return "DateBean{" +
                        "id=" + id +
                        ", status=" + status +
                        ", title='" + title + '\'' +
                        ", image='" + image + '\'' +
                        '}';
            }

            /**
             * id : 0
             * status : 1
             * title : 中间
             * image : haha
             */


            private int id;
            private int status;
            private String title;
            private String image;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }
        }
    }
}
