package com.pdd.wiki.domain;

import java.util.ArrayList;
import java.util.List;

public class EbookExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EbookExample() {
        oredCriteria = new ArrayList<>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andBookNameIsNull() {
            addCriterion("book_name is null");
            return (Criteria) this;
        }

        public Criteria andBookNameIsNotNull() {
            addCriterion("book_name is not null");
            return (Criteria) this;
        }

        public Criteria andBookNameEqualTo(String value) {
            addCriterion("book_name =", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameNotEqualTo(String value) {
            addCriterion("book_name <>", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameGreaterThan(String value) {
            addCriterion("book_name >", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameGreaterThanOrEqualTo(String value) {
            addCriterion("book_name >=", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameLessThan(String value) {
            addCriterion("book_name <", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameLessThanOrEqualTo(String value) {
            addCriterion("book_name <=", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameLike(String value) {
            addCriterion("book_name like", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameNotLike(String value) {
            addCriterion("book_name not like", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameIn(List<String> values) {
            addCriterion("book_name in", values, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameNotIn(List<String> values) {
            addCriterion("book_name not in", values, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameBetween(String value1, String value2) {
            addCriterion("book_name between", value1, value2, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameNotBetween(String value1, String value2) {
            addCriterion("book_name not between", value1, value2, "bookName");
            return (Criteria) this;
        }

        public Criteria andCategory1IsNull() {
            addCriterion("category_1 is null");
            return (Criteria) this;
        }

        public Criteria andCategory1IsNotNull() {
            addCriterion("category_1 is not null");
            return (Criteria) this;
        }

        public Criteria andCategory1EqualTo(Long value) {
            addCriterion("category_1 =", value, "category1");
            return (Criteria) this;
        }

        public Criteria andCategory1NotEqualTo(Long value) {
            addCriterion("category_1 <>", value, "category1");
            return (Criteria) this;
        }

        public Criteria andCategory1GreaterThan(Long value) {
            addCriterion("category_1 >", value, "category1");
            return (Criteria) this;
        }

        public Criteria andCategory1GreaterThanOrEqualTo(Long value) {
            addCriterion("category_1 >=", value, "category1");
            return (Criteria) this;
        }

        public Criteria andCategory1LessThan(Long value) {
            addCriterion("category_1 <", value, "category1");
            return (Criteria) this;
        }

        public Criteria andCategory1LessThanOrEqualTo(Long value) {
            addCriterion("category_1 <=", value, "category1");
            return (Criteria) this;
        }

        public Criteria andCategory1In(List<Long> values) {
            addCriterion("category_1 in", values, "category1");
            return (Criteria) this;
        }

        public Criteria andCategory1NotIn(List<Long> values) {
            addCriterion("category_1 not in", values, "category1");
            return (Criteria) this;
        }

        public Criteria andCategory1Between(Long value1, Long value2) {
            addCriterion("category_1 between", value1, value2, "category1");
            return (Criteria) this;
        }

        public Criteria andCategory1NotBetween(Long value1, Long value2) {
            addCriterion("category_1 not between", value1, value2, "category1");
            return (Criteria) this;
        }

        public Criteria andCategory2IsNull() {
            addCriterion("category_2 is null");
            return (Criteria) this;
        }

        public Criteria andCategory2IsNotNull() {
            addCriterion("category_2 is not null");
            return (Criteria) this;
        }

        public Criteria andCategory2EqualTo(Long value) {
            addCriterion("category_2 =", value, "category2");
            return (Criteria) this;
        }

        public Criteria andCategory2NotEqualTo(Long value) {
            addCriterion("category_2 <>", value, "category2");
            return (Criteria) this;
        }

        public Criteria andCategory2GreaterThan(Long value) {
            addCriterion("category_2 >", value, "category2");
            return (Criteria) this;
        }

        public Criteria andCategory2GreaterThanOrEqualTo(Long value) {
            addCriterion("category_2 >=", value, "category2");
            return (Criteria) this;
        }

        public Criteria andCategory2LessThan(Long value) {
            addCriterion("category_2 <", value, "category2");
            return (Criteria) this;
        }

        public Criteria andCategory2LessThanOrEqualTo(Long value) {
            addCriterion("category_2 <=", value, "category2");
            return (Criteria) this;
        }

        public Criteria andCategory2In(List<Long> values) {
            addCriterion("category_2 in", values, "category2");
            return (Criteria) this;
        }

        public Criteria andCategory2NotIn(List<Long> values) {
            addCriterion("category_2 not in", values, "category2");
            return (Criteria) this;
        }

        public Criteria andCategory2Between(Long value1, Long value2) {
            addCriterion("category_2 between", value1, value2, "category2");
            return (Criteria) this;
        }

        public Criteria andCategory2NotBetween(Long value1, Long value2) {
            addCriterion("category_2 not between", value1, value2, "category2");
            return (Criteria) this;
        }

        public Criteria andBookDescIsNull() {
            addCriterion("book_desc is null");
            return (Criteria) this;
        }

        public Criteria andBookDescIsNotNull() {
            addCriterion("book_desc is not null");
            return (Criteria) this;
        }

        public Criteria andBookDescEqualTo(String value) {
            addCriterion("book_desc =", value, "bookDesc");
            return (Criteria) this;
        }

        public Criteria andBookDescNotEqualTo(String value) {
            addCriterion("book_desc <>", value, "bookDesc");
            return (Criteria) this;
        }

        public Criteria andBookDescGreaterThan(String value) {
            addCriterion("book_desc >", value, "bookDesc");
            return (Criteria) this;
        }

        public Criteria andBookDescGreaterThanOrEqualTo(String value) {
            addCriterion("book_desc >=", value, "bookDesc");
            return (Criteria) this;
        }

        public Criteria andBookDescLessThan(String value) {
            addCriterion("book_desc <", value, "bookDesc");
            return (Criteria) this;
        }

        public Criteria andBookDescLessThanOrEqualTo(String value) {
            addCriterion("book_desc <=", value, "bookDesc");
            return (Criteria) this;
        }

        public Criteria andBookDescLike(String value) {
            addCriterion("book_desc like", value, "bookDesc");
            return (Criteria) this;
        }

        public Criteria andBookDescNotLike(String value) {
            addCriterion("book_desc not like", value, "bookDesc");
            return (Criteria) this;
        }

        public Criteria andBookDescIn(List<String> values) {
            addCriterion("book_desc in", values, "bookDesc");
            return (Criteria) this;
        }

        public Criteria andBookDescNotIn(List<String> values) {
            addCriterion("book_desc not in", values, "bookDesc");
            return (Criteria) this;
        }

        public Criteria andBookDescBetween(String value1, String value2) {
            addCriterion("book_desc between", value1, value2, "bookDesc");
            return (Criteria) this;
        }

        public Criteria andBookDescNotBetween(String value1, String value2) {
            addCriterion("book_desc not between", value1, value2, "bookDesc");
            return (Criteria) this;
        }

        public Criteria andBookCoverIsNull() {
            addCriterion("book_cover is null");
            return (Criteria) this;
        }

        public Criteria andBookCoverIsNotNull() {
            addCriterion("book_cover is not null");
            return (Criteria) this;
        }

        public Criteria andBookCoverEqualTo(String value) {
            addCriterion("book_cover =", value, "bookCover");
            return (Criteria) this;
        }

        public Criteria andBookCoverNotEqualTo(String value) {
            addCriterion("book_cover <>", value, "bookCover");
            return (Criteria) this;
        }

        public Criteria andBookCoverGreaterThan(String value) {
            addCriterion("book_cover >", value, "bookCover");
            return (Criteria) this;
        }

        public Criteria andBookCoverGreaterThanOrEqualTo(String value) {
            addCriterion("book_cover >=", value, "bookCover");
            return (Criteria) this;
        }

        public Criteria andBookCoverLessThan(String value) {
            addCriterion("book_cover <", value, "bookCover");
            return (Criteria) this;
        }

        public Criteria andBookCoverLessThanOrEqualTo(String value) {
            addCriterion("book_cover <=", value, "bookCover");
            return (Criteria) this;
        }

        public Criteria andBookCoverLike(String value) {
            addCriterion("book_cover like", value, "bookCover");
            return (Criteria) this;
        }

        public Criteria andBookCoverNotLike(String value) {
            addCriterion("book_cover not like", value, "bookCover");
            return (Criteria) this;
        }

        public Criteria andBookCoverIn(List<String> values) {
            addCriterion("book_cover in", values, "bookCover");
            return (Criteria) this;
        }

        public Criteria andBookCoverNotIn(List<String> values) {
            addCriterion("book_cover not in", values, "bookCover");
            return (Criteria) this;
        }

        public Criteria andBookCoverBetween(String value1, String value2) {
            addCriterion("book_cover between", value1, value2, "bookCover");
            return (Criteria) this;
        }

        public Criteria andBookCoverNotBetween(String value1, String value2) {
            addCriterion("book_cover not between", value1, value2, "bookCover");
            return (Criteria) this;
        }

        public Criteria andDocCountIsNull() {
            addCriterion("doc_count is null");
            return (Criteria) this;
        }

        public Criteria andDocCountIsNotNull() {
            addCriterion("doc_count is not null");
            return (Criteria) this;
        }

        public Criteria andDocCountEqualTo(Long value) {
            addCriterion("doc_count =", value, "docCount");
            return (Criteria) this;
        }

        public Criteria andDocCountNotEqualTo(Long value) {
            addCriterion("doc_count <>", value, "docCount");
            return (Criteria) this;
        }

        public Criteria andDocCountGreaterThan(Long value) {
            addCriterion("doc_count >", value, "docCount");
            return (Criteria) this;
        }

        public Criteria andDocCountGreaterThanOrEqualTo(Long value) {
            addCriterion("doc_count >=", value, "docCount");
            return (Criteria) this;
        }

        public Criteria andDocCountLessThan(Long value) {
            addCriterion("doc_count <", value, "docCount");
            return (Criteria) this;
        }

        public Criteria andDocCountLessThanOrEqualTo(Long value) {
            addCriterion("doc_count <=", value, "docCount");
            return (Criteria) this;
        }

        public Criteria andDocCountIn(List<Long> values) {
            addCriterion("doc_count in", values, "docCount");
            return (Criteria) this;
        }

        public Criteria andDocCountNotIn(List<Long> values) {
            addCriterion("doc_count not in", values, "docCount");
            return (Criteria) this;
        }

        public Criteria andDocCountBetween(Long value1, Long value2) {
            addCriterion("doc_count between", value1, value2, "docCount");
            return (Criteria) this;
        }

        public Criteria andDocCountNotBetween(Long value1, Long value2) {
            addCriterion("doc_count not between", value1, value2, "docCount");
            return (Criteria) this;
        }

        public Criteria andViewCountIsNull() {
            addCriterion("view_count is null");
            return (Criteria) this;
        }

        public Criteria andViewCountIsNotNull() {
            addCriterion("view_count is not null");
            return (Criteria) this;
        }

        public Criteria andViewCountEqualTo(Long value) {
            addCriterion("view_count =", value, "viewCount");
            return (Criteria) this;
        }

        public Criteria andViewCountNotEqualTo(Long value) {
            addCriterion("view_count <>", value, "viewCount");
            return (Criteria) this;
        }

        public Criteria andViewCountGreaterThan(Long value) {
            addCriterion("view_count >", value, "viewCount");
            return (Criteria) this;
        }

        public Criteria andViewCountGreaterThanOrEqualTo(Long value) {
            addCriterion("view_count >=", value, "viewCount");
            return (Criteria) this;
        }

        public Criteria andViewCountLessThan(Long value) {
            addCriterion("view_count <", value, "viewCount");
            return (Criteria) this;
        }

        public Criteria andViewCountLessThanOrEqualTo(Long value) {
            addCriterion("view_count <=", value, "viewCount");
            return (Criteria) this;
        }

        public Criteria andViewCountIn(List<Long> values) {
            addCriterion("view_count in", values, "viewCount");
            return (Criteria) this;
        }

        public Criteria andViewCountNotIn(List<Long> values) {
            addCriterion("view_count not in", values, "viewCount");
            return (Criteria) this;
        }

        public Criteria andViewCountBetween(Long value1, Long value2) {
            addCriterion("view_count between", value1, value2, "viewCount");
            return (Criteria) this;
        }

        public Criteria andViewCountNotBetween(Long value1, Long value2) {
            addCriterion("view_count not between", value1, value2, "viewCount");
            return (Criteria) this;
        }

        public Criteria andLikeCountIsNull() {
            addCriterion("like_count is null");
            return (Criteria) this;
        }

        public Criteria andLikeCountIsNotNull() {
            addCriterion("like_count is not null");
            return (Criteria) this;
        }

        public Criteria andLikeCountEqualTo(Long value) {
            addCriterion("like_count =", value, "likeCount");
            return (Criteria) this;
        }

        public Criteria andLikeCountNotEqualTo(Long value) {
            addCriterion("like_count <>", value, "likeCount");
            return (Criteria) this;
        }

        public Criteria andLikeCountGreaterThan(Long value) {
            addCriterion("like_count >", value, "likeCount");
            return (Criteria) this;
        }

        public Criteria andLikeCountGreaterThanOrEqualTo(Long value) {
            addCriterion("like_count >=", value, "likeCount");
            return (Criteria) this;
        }

        public Criteria andLikeCountLessThan(Long value) {
            addCriterion("like_count <", value, "likeCount");
            return (Criteria) this;
        }

        public Criteria andLikeCountLessThanOrEqualTo(Long value) {
            addCriterion("like_count <=", value, "likeCount");
            return (Criteria) this;
        }

        public Criteria andLikeCountIn(List<Long> values) {
            addCriterion("like_count in", values, "likeCount");
            return (Criteria) this;
        }

        public Criteria andLikeCountNotIn(List<Long> values) {
            addCriterion("like_count not in", values, "likeCount");
            return (Criteria) this;
        }

        public Criteria andLikeCountBetween(Long value1, Long value2) {
            addCriterion("like_count between", value1, value2, "likeCount");
            return (Criteria) this;
        }

        public Criteria andLikeCountNotBetween(Long value1, Long value2) {
            addCriterion("like_count not between", value1, value2, "likeCount");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}