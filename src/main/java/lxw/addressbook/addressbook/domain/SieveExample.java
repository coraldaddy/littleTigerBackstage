package lxw.addressbook.addressbook.domain;

import java.util.ArrayList;
import java.util.List;

public class SieveExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SieveExample() {
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
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andJettonIsNull() {
            addCriterion("jetton is null");
            return (Criteria) this;
        }

        public Criteria andJettonIsNotNull() {
            addCriterion("jetton is not null");
            return (Criteria) this;
        }

        public Criteria andJettonEqualTo(String value) {
            addCriterion("jetton =", value, "jetton");
            return (Criteria) this;
        }

        public Criteria andJettonNotEqualTo(String value) {
            addCriterion("jetton <>", value, "jetton");
            return (Criteria) this;
        }

        public Criteria andJettonGreaterThan(String value) {
            addCriterion("jetton >", value, "jetton");
            return (Criteria) this;
        }

        public Criteria andJettonGreaterThanOrEqualTo(String value) {
            addCriterion("jetton >=", value, "jetton");
            return (Criteria) this;
        }

        public Criteria andJettonLessThan(String value) {
            addCriterion("jetton <", value, "jetton");
            return (Criteria) this;
        }

        public Criteria andJettonLessThanOrEqualTo(String value) {
            addCriterion("jetton <=", value, "jetton");
            return (Criteria) this;
        }

        public Criteria andJettonLike(String value) {
            addCriterion("jetton like", value, "jetton");
            return (Criteria) this;
        }

        public Criteria andJettonNotLike(String value) {
            addCriterion("jetton not like", value, "jetton");
            return (Criteria) this;
        }

        public Criteria andJettonIn(List<String> values) {
            addCriterion("jetton in", values, "jetton");
            return (Criteria) this;
        }

        public Criteria andJettonNotIn(List<String> values) {
            addCriterion("jetton not in", values, "jetton");
            return (Criteria) this;
        }

        public Criteria andJettonBetween(String value1, String value2) {
            addCriterion("jetton between", value1, value2, "jetton");
            return (Criteria) this;
        }

        public Criteria andJettonNotBetween(String value1, String value2) {
            addCriterion("jetton not between", value1, value2, "jetton");
            return (Criteria) this;
        }

        public Criteria andHighestIsNull() {
            addCriterion("highest is null");
            return (Criteria) this;
        }

        public Criteria andHighestIsNotNull() {
            addCriterion("highest is not null");
            return (Criteria) this;
        }

        public Criteria andHighestEqualTo(String value) {
            addCriterion("highest =", value, "highest");
            return (Criteria) this;
        }

        public Criteria andHighestNotEqualTo(String value) {
            addCriterion("highest <>", value, "highest");
            return (Criteria) this;
        }

        public Criteria andHighestGreaterThan(String value) {
            addCriterion("highest >", value, "highest");
            return (Criteria) this;
        }

        public Criteria andHighestGreaterThanOrEqualTo(String value) {
            addCriterion("highest >=", value, "highest");
            return (Criteria) this;
        }

        public Criteria andHighestLessThan(String value) {
            addCriterion("highest <", value, "highest");
            return (Criteria) this;
        }

        public Criteria andHighestLessThanOrEqualTo(String value) {
            addCriterion("highest <=", value, "highest");
            return (Criteria) this;
        }

        public Criteria andHighestLike(String value) {
            addCriterion("highest like", value, "highest");
            return (Criteria) this;
        }

        public Criteria andHighestNotLike(String value) {
            addCriterion("highest not like", value, "highest");
            return (Criteria) this;
        }

        public Criteria andHighestIn(List<String> values) {
            addCriterion("highest in", values, "highest");
            return (Criteria) this;
        }

        public Criteria andHighestNotIn(List<String> values) {
            addCriterion("highest not in", values, "highest");
            return (Criteria) this;
        }

        public Criteria andHighestBetween(String value1, String value2) {
            addCriterion("highest between", value1, value2, "highest");
            return (Criteria) this;
        }

        public Criteria andHighestNotBetween(String value1, String value2) {
            addCriterion("highest not between", value1, value2, "highest");
            return (Criteria) this;
        }

        public Criteria andQuickNumIsNull() {
            addCriterion("quick_num is null");
            return (Criteria) this;
        }

        public Criteria andQuickNumIsNotNull() {
            addCriterion("quick_num is not null");
            return (Criteria) this;
        }

        public Criteria andQuickNumEqualTo(Integer value) {
            addCriterion("quick_num =", value, "quickNum");
            return (Criteria) this;
        }

        public Criteria andQuickNumNotEqualTo(Integer value) {
            addCriterion("quick_num <>", value, "quickNum");
            return (Criteria) this;
        }

        public Criteria andQuickNumGreaterThan(Integer value) {
            addCriterion("quick_num >", value, "quickNum");
            return (Criteria) this;
        }

        public Criteria andQuickNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("quick_num >=", value, "quickNum");
            return (Criteria) this;
        }

        public Criteria andQuickNumLessThan(Integer value) {
            addCriterion("quick_num <", value, "quickNum");
            return (Criteria) this;
        }

        public Criteria andQuickNumLessThanOrEqualTo(Integer value) {
            addCriterion("quick_num <=", value, "quickNum");
            return (Criteria) this;
        }

        public Criteria andQuickNumIn(List<Integer> values) {
            addCriterion("quick_num in", values, "quickNum");
            return (Criteria) this;
        }

        public Criteria andQuickNumNotIn(List<Integer> values) {
            addCriterion("quick_num not in", values, "quickNum");
            return (Criteria) this;
        }

        public Criteria andQuickNumBetween(Integer value1, Integer value2) {
            addCriterion("quick_num between", value1, value2, "quickNum");
            return (Criteria) this;
        }

        public Criteria andQuickNumNotBetween(Integer value1, Integer value2) {
            addCriterion("quick_num not between", value1, value2, "quickNum");
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