package com.entity;

import java.util.List;

/**
 * Created by liguoying on 2017/9/22.
 */

public class DayEntity {

    /**
     *
     * {"code" : ok ,"content" : [{"name":"今天","date":[{"title":"中间","image":"haha"},{"title":" 中间 ","image":"haha"},{"title":" 中间 ","image":"haha"}]},{"name":"明天","date":[{"title":"中间","image":"haha"},{"title":"中间","image":"haha"},{"title":"中间","image":"haha"}]},{"name":"明天","date":[{"title":"中间","image":"haha"},{"title":"中间","image":"haha"},{"title":"中间","image":"haha"}]}]}
     * code : ok
     * content : [{"name":"今天","date":[{"title":"中间","image":"haha"},{"title":" 中间 ","image":"haha"},{"title":" 中间 ","image":"haha"}]},{"name":"明天","date":[{"title":"中间","image":"haha"},{"title":"中间","image":"haha"},{"title":"中间","image":"haha"}]},{"name":"明天","date":[{"title":"中间","image":"haha"},{"title":"中间","image":"haha"},{"title":"中间","image":"haha"}]}]
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
        /**
         * name : 今天
         * date : [{"title":"中间","image":"haha"},{"title":" 中间 ","image":"haha"},{"title":" 中间 ","image":"haha"}]
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
            /**
             * title : 中间
             * image : haha
             */

            private String title;
            private String image;

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
