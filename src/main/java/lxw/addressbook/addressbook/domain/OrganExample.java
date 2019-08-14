package lxw.addressbook.addressbook.domain;

import java.util.ArrayList;
import java.util.List;

public class OrganExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrganExample() {
        oredCriteria = new ArrayList<Criteria>();
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
            criteria = new ArrayList<Criterion>();
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
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andOrganNameIsNull() {
            addCriterion("ORGAN_NAME is null");
            return (Criteria) this;
        }

        public Criteria andOrganNameIsNotNull() {
            addCriterion("ORGAN_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andOrganNameEqualTo(String value) {
            addCriterion("ORGAN_NAME =", value, "organName");
            return (Criteria) this;
        }

        public Criteria andOrganNameNotEqualTo(String value) {
            addCriterion("ORGAN_NAME <>", value, "organName");
            return (Criteria) this;
        }

        public Criteria andOrganNameGreaterThan(String value) {
            addCriterion("ORGAN_NAME >", value, "organName");
            return (Criteria) this;
        }

        public Criteria andOrganNameGreaterThanOrEqualTo(String value) {
            addCriterion("ORGAN_NAME >=", value, "organName");
            return (Criteria) this;
        }

        public Criteria andOrganNameLessThan(String value) {
            addCriterion("ORGAN_NAME <", value, "organName");
            return (Criteria) this;
        }

        public Criteria andOrganNameLessThanOrEqualTo(String value) {
            addCriterion("ORGAN_NAME <=", value, "organName");
            return (Criteria) this;
        }

        public Criteria andOrganNameLike(String value) {
            addCriterion("ORGAN_NAME like", value, "organName");
            return (Criteria) this;
        }

        public Criteria andOrganNameNotLike(String value) {
            addCriterion("ORGAN_NAME not like", value, "organName");
            return (Criteria) this;
        }

        public Criteria andOrganNameIn(List<String> values) {
            addCriterion("ORGAN_NAME in", values, "organName");
            return (Criteria) this;
        }

        public Criteria andOrganNameNotIn(List<String> values) {
            addCriterion("ORGAN_NAME not in", values, "organName");
            return (Criteria) this;
        }

        public Criteria andOrganNameBetween(String value1, String value2) {
            addCriterion("ORGAN_NAME between", value1, value2, "organName");
            return (Criteria) this;
        }

        public Criteria andOrganNameNotBetween(String value1, String value2) {
            addCriterion("ORGAN_NAME not between", value1, value2, "organName");
            return (Criteria) this;
        }

        public Criteria andParentOrganNameIsNull() {
            addCriterion("PARENT_ORGAN_NAME is null");
            return (Criteria) this;
        }

        public Criteria andParentOrganNameIsNotNull() {
            addCriterion("PARENT_ORGAN_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andParentOrganNameEqualTo(String value) {
            addCriterion("PARENT_ORGAN_NAME =", value, "parentOrganName");
            return (Criteria) this;
        }

        public Criteria andParentOrganNameNotEqualTo(String value) {
            addCriterion("PARENT_ORGAN_NAME <>", value, "parentOrganName");
            return (Criteria) this;
        }

        public Criteria andParentOrganNameGreaterThan(String value) {
            addCriterion("PARENT_ORGAN_NAME >", value, "parentOrganName");
            return (Criteria) this;
        }

        public Criteria andParentOrganNameGreaterThanOrEqualTo(String value) {
            addCriterion("PARENT_ORGAN_NAME >=", value, "parentOrganName");
            return (Criteria) this;
        }

        public Criteria andParentOrganNameLessThan(String value) {
            addCriterion("PARENT_ORGAN_NAME <", value, "parentOrganName");
            return (Criteria) this;
        }

        public Criteria andParentOrganNameLessThanOrEqualTo(String value) {
            addCriterion("PARENT_ORGAN_NAME <=", value, "parentOrganName");
            return (Criteria) this;
        }

        public Criteria andParentOrganNameLike(String value) {
            addCriterion("PARENT_ORGAN_NAME like", value, "parentOrganName");
            return (Criteria) this;
        }

        public Criteria andParentOrganNameNotLike(String value) {
            addCriterion("PARENT_ORGAN_NAME not like", value, "parentOrganName");
            return (Criteria) this;
        }

        public Criteria andParentOrganNameIn(List<String> values) {
            addCriterion("PARENT_ORGAN_NAME in", values, "parentOrganName");
            return (Criteria) this;
        }

        public Criteria andParentOrganNameNotIn(List<String> values) {
            addCriterion("PARENT_ORGAN_NAME not in", values, "parentOrganName");
            return (Criteria) this;
        }

        public Criteria andParentOrganNameBetween(String value1, String value2) {
            addCriterion("PARENT_ORGAN_NAME between", value1, value2, "parentOrganName");
            return (Criteria) this;
        }

        public Criteria andParentOrganNameNotBetween(String value1, String value2) {
            addCriterion("PARENT_ORGAN_NAME not between", value1, value2, "parentOrganName");
            return (Criteria) this;
        }

        public Criteria andOrganInfoIsNull() {
            addCriterion("ORGAN_INFO is null");
            return (Criteria) this;
        }

        public Criteria andOrganInfoIsNotNull() {
            addCriterion("ORGAN_INFO is not null");
            return (Criteria) this;
        }

        public Criteria andOrganInfoEqualTo(String value) {
            addCriterion("ORGAN_INFO =", value, "organInfo");
            return (Criteria) this;
        }

        public Criteria andOrganInfoNotEqualTo(String value) {
            addCriterion("ORGAN_INFO <>", value, "organInfo");
            return (Criteria) this;
        }

        public Criteria andOrganInfoGreaterThan(String value) {
            addCriterion("ORGAN_INFO >", value, "organInfo");
            return (Criteria) this;
        }

        public Criteria andOrganInfoGreaterThanOrEqualTo(String value) {
            addCriterion("ORGAN_INFO >=", value, "organInfo");
            return (Criteria) this;
        }

        public Criteria andOrganInfoLessThan(String value) {
            addCriterion("ORGAN_INFO <", value, "organInfo");
            return (Criteria) this;
        }

        public Criteria andOrganInfoLessThanOrEqualTo(String value) {
            addCriterion("ORGAN_INFO <=", value, "organInfo");
            return (Criteria) this;
        }

        public Criteria andOrganInfoLike(String value) {
            addCriterion("ORGAN_INFO like", value, "organInfo");
            return (Criteria) this;
        }

        public Criteria andOrganInfoNotLike(String value) {
            addCriterion("ORGAN_INFO not like", value, "organInfo");
            return (Criteria) this;
        }

        public Criteria andOrganInfoIn(List<String> values) {
            addCriterion("ORGAN_INFO in", values, "organInfo");
            return (Criteria) this;
        }

        public Criteria andOrganInfoNotIn(List<String> values) {
            addCriterion("ORGAN_INFO not in", values, "organInfo");
            return (Criteria) this;
        }

        public Criteria andOrganInfoBetween(String value1, String value2) {
            addCriterion("ORGAN_INFO between", value1, value2, "organInfo");
            return (Criteria) this;
        }

        public Criteria andOrganInfoNotBetween(String value1, String value2) {
            addCriterion("ORGAN_INFO not between", value1, value2, "organInfo");
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