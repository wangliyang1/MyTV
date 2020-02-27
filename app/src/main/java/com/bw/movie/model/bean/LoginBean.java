package com.bw.movie.model.bean;

public class LoginBean {

    /**
     * result : {"sessionId":"158272162595813760","userId":13760,"userInfo":{"birthday":871488000000,"email":"364086070@qq.com","headPic":"http://mobile.bwstudent.com/images/movie/head_pic/2020-02-21/20200221212619.webp","id":13760,"lastLoginTime":1582289869000,"nickName":"王黎杨","phone":"18531029738","sex":1}}
     * message : 登陆成功
     * status : 0000
     */

    private ResultBean result;
    private String message;
    private String status;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static class ResultBean {
        /**
         * sessionId : 158272162595813760
         * userId : 13760
         * userInfo : {"birthday":871488000000,"email":"364086070@qq.com","headPic":"http://mobile.bwstudent.com/images/movie/head_pic/2020-02-21/20200221212619.webp","id":13760,"lastLoginTime":1582289869000,"nickName":"王黎杨","phone":"18531029738","sex":1}
         */

        private String sessionId;
        private int userId;
        private UserInfoBean userInfo;

        public String getSessionId() {
            return sessionId;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public UserInfoBean getUserInfo() {
            return userInfo;
        }

        public void setUserInfo(UserInfoBean userInfo) {
            this.userInfo = userInfo;
        }

        public static class UserInfoBean {
            /**
             * birthday : 871488000000
             * email : 364086070@qq.com
             * headPic : http://mobile.bwstudent.com/images/movie/head_pic/2020-02-21/20200221212619.webp
             * id : 13760
             * lastLoginTime : 1582289869000
             * nickName : 王黎杨
             * phone : 18531029738
             * sex : 1
             */

            private long birthday;
            private String email;
            private String headPic;
            private int id;
            private long lastLoginTime;
            private String nickName;
            private String phone;
            private int sex;

            public long getBirthday() {
                return birthday;
            }

            public void setBirthday(long birthday) {
                this.birthday = birthday;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public String getHeadPic() {
                return headPic;
            }

            public void setHeadPic(String headPic) {
                this.headPic = headPic;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public long getLastLoginTime() {
                return lastLoginTime;
            }

            public void setLastLoginTime(long lastLoginTime) {
                this.lastLoginTime = lastLoginTime;
            }

            public String getNickName() {
                return nickName;
            }

            public void setNickName(String nickName) {
                this.nickName = nickName;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public int getSex() {
                return sex;
            }

            public void setSex(int sex) {
                this.sex = sex;
            }
        }
    }
}
