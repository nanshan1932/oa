package com.naokang.oa.common.constants;

public class SysConstants {
    /**
     * 有效标记类型<br>
     * 0有效，-1无效
     */
    public static class MarkType {

        public static final int VALID = 0;
        public static final int INVALID = -1;
        public static final String VALID_STR = "0";
        public static final String INVALID_STR = "-1";
    }


    /**
     * 页码常量
     */
    public static class Page {

        /**
         * 默认页码
         */
        public static final int PAGE_NUMBER_DEFAULT = 1;
        /**
         * 默认页容量
         */
        public static final int PAGE_SIZE_DEFAULT = 10;

        /**
         * 页容量最大值
         */
        public static final int PAGE_SIZE_MAX = 500;
    }

}
