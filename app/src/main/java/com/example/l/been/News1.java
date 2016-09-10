package com.example.l.been;

import java.util.List;

/**
 * Created by L on 2016/9/5.
 */
public class News1 {

    /**
     * title : 4K摄像新选择 佳能CX15将于本月上市发售
     * pic_url : http://img2.fengniao.com/product/157_160x120/690/cewHLhxKGclA.jpg
     * date : 2016-09-05 06:00:00
     * author : 房时宇
     * doc_url : http://api.fengniao.com/app_ipad/news_doc.php?docid=5338563&isPad=1
     * doc_id : 5338563
     * web_url : http://qicai.fengniao.com/533/5338563.html
     * comment_page_num : 0
     * comments_num : 0
     * more_comment_url : http://api.fengniao.com/app_ipad/news_doc_comments.php?docid=5338563&isPad=1
     */

    private List<SpecificBean> specific;
    /**
     * title : 专业电影变焦头 蔡司LWZ.3 预计明年发售
     * pic_url : http://img2.fengniao.com/product/157_280x280/636/ce1Rlt9GpUJXw.jpg
     * date : 2016-09-05 06:00:00
     * doc_url : http://api.fengniao.com/app_ipad/news_doc.php?docid=5338549&isPad=1
     * doc_id : 5338549
     * web_url : http://qicai.fengniao.com/533/5338549.html
     * comment_page_num : 0
     * comments_num : 0
     * more_comment_url : http://api.fengniao.com/app_ipad/news_doc_comments.php?docid=5338549&isPad=1
     */

    private List<EspeciallyBean> especially;

    public List<SpecificBean> getSpecific() {
        return specific;
    }

    public void setSpecific(List<SpecificBean> specific) {
        this.specific = specific;
    }

    public List<EspeciallyBean> getEspecially() {
        return especially;
    }

    public void setEspecially(List<EspeciallyBean> especially) {
        this.especially = especially;
    }

    public static class SpecificBean {
        private String title;
        private String pic_url;
        private String date;
        private String author;
        private String doc_url;
        private String doc_id;
        private String web_url;
        private int comment_page_num;
        private String comments_num;
        private String more_comment_url;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPic_url() {
            return pic_url;
        }

        public void setPic_url(String pic_url) {
            this.pic_url = pic_url;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getDoc_url() {
            return doc_url;
        }

        public void setDoc_url(String doc_url) {
            this.doc_url = doc_url;
        }

        public String getDoc_id() {
            return doc_id;
        }

        public void setDoc_id(String doc_id) {
            this.doc_id = doc_id;
        }

        public String getWeb_url() {
            return web_url;
        }

        public void setWeb_url(String web_url) {
            this.web_url = web_url;
        }

        public int getComment_page_num() {
            return comment_page_num;
        }

        public void setComment_page_num(int comment_page_num) {
            this.comment_page_num = comment_page_num;
        }

        public String getComments_num() {
            return comments_num;
        }

        public void setComments_num(String comments_num) {
            this.comments_num = comments_num;
        }

        public String getMore_comment_url() {
            return more_comment_url;
        }

        public void setMore_comment_url(String more_comment_url) {
            this.more_comment_url = more_comment_url;
        }
    }

    public static class EspeciallyBean {
        private String title;
        private String pic_url;
        private String date;
        private String doc_url;
        private String doc_id;
        private String web_url;
        private int comment_page_num;
        private String comments_num;
        private String more_comment_url;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPic_url() {
            return pic_url;
        }

        public void setPic_url(String pic_url) {
            this.pic_url = pic_url;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getDoc_url() {
            return doc_url;
        }

        public void setDoc_url(String doc_url) {
            this.doc_url = doc_url;
        }

        public String getDoc_id() {
            return doc_id;
        }

        public void setDoc_id(String doc_id) {
            this.doc_id = doc_id;
        }

        public String getWeb_url() {
            return web_url;
        }

        public void setWeb_url(String web_url) {
            this.web_url = web_url;
        }

        public int getComment_page_num() {
            return comment_page_num;
        }

        public void setComment_page_num(int comment_page_num) {
            this.comment_page_num = comment_page_num;
        }

        public String getComments_num() {
            return comments_num;
        }

        public void setComments_num(String comments_num) {
            this.comments_num = comments_num;
        }

        public String getMore_comment_url() {
            return more_comment_url;
        }

        public void setMore_comment_url(String more_comment_url) {
            this.more_comment_url = more_comment_url;
        }
    }
}
