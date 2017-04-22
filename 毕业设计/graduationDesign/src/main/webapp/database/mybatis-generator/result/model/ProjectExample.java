package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ProjectExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProjectExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andProjectNoIsNull() {
            addCriterion("project_no is null");
            return (Criteria) this;
        }

        public Criteria andProjectNoIsNotNull() {
            addCriterion("project_no is not null");
            return (Criteria) this;
        }

        public Criteria andProjectNoEqualTo(Integer value) {
            addCriterion("project_no =", value, "projectNo");
            return (Criteria) this;
        }

        public Criteria andProjectNoNotEqualTo(Integer value) {
            addCriterion("project_no <>", value, "projectNo");
            return (Criteria) this;
        }

        public Criteria andProjectNoGreaterThan(Integer value) {
            addCriterion("project_no >", value, "projectNo");
            return (Criteria) this;
        }

        public Criteria andProjectNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("project_no >=", value, "projectNo");
            return (Criteria) this;
        }

        public Criteria andProjectNoLessThan(Integer value) {
            addCriterion("project_no <", value, "projectNo");
            return (Criteria) this;
        }

        public Criteria andProjectNoLessThanOrEqualTo(Integer value) {
            addCriterion("project_no <=", value, "projectNo");
            return (Criteria) this;
        }

        public Criteria andProjectNoIn(List<Integer> values) {
            addCriterion("project_no in", values, "projectNo");
            return (Criteria) this;
        }

        public Criteria andProjectNoNotIn(List<Integer> values) {
            addCriterion("project_no not in", values, "projectNo");
            return (Criteria) this;
        }

        public Criteria andProjectNoBetween(Integer value1, Integer value2) {
            addCriterion("project_no between", value1, value2, "projectNo");
            return (Criteria) this;
        }

        public Criteria andProjectNoNotBetween(Integer value1, Integer value2) {
            addCriterion("project_no not between", value1, value2, "projectNo");
            return (Criteria) this;
        }

        public Criteria andProjectNameIsNull() {
            addCriterion("project_name is null");
            return (Criteria) this;
        }

        public Criteria andProjectNameIsNotNull() {
            addCriterion("project_name is not null");
            return (Criteria) this;
        }

        public Criteria andProjectNameEqualTo(String value) {
            addCriterion("project_name =", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotEqualTo(String value) {
            addCriterion("project_name <>", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThan(String value) {
            addCriterion("project_name >", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThanOrEqualTo(String value) {
            addCriterion("project_name >=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThan(String value) {
            addCriterion("project_name <", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThanOrEqualTo(String value) {
            addCriterion("project_name <=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLike(String value) {
            addCriterion("project_name like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotLike(String value) {
            addCriterion("project_name not like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameIn(List<String> values) {
            addCriterion("project_name in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotIn(List<String> values) {
            addCriterion("project_name not in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameBetween(String value1, String value2) {
            addCriterion("project_name between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotBetween(String value1, String value2) {
            addCriterion("project_name not between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andHomeNoIsNull() {
            addCriterion("home_no is null");
            return (Criteria) this;
        }

        public Criteria andHomeNoIsNotNull() {
            addCriterion("home_no is not null");
            return (Criteria) this;
        }

        public Criteria andHomeNoEqualTo(Integer value) {
            addCriterion("home_no =", value, "homeNo");
            return (Criteria) this;
        }

        public Criteria andHomeNoNotEqualTo(Integer value) {
            addCriterion("home_no <>", value, "homeNo");
            return (Criteria) this;
        }

        public Criteria andHomeNoGreaterThan(Integer value) {
            addCriterion("home_no >", value, "homeNo");
            return (Criteria) this;
        }

        public Criteria andHomeNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("home_no >=", value, "homeNo");
            return (Criteria) this;
        }

        public Criteria andHomeNoLessThan(Integer value) {
            addCriterion("home_no <", value, "homeNo");
            return (Criteria) this;
        }

        public Criteria andHomeNoLessThanOrEqualTo(Integer value) {
            addCriterion("home_no <=", value, "homeNo");
            return (Criteria) this;
        }

        public Criteria andHomeNoIn(List<Integer> values) {
            addCriterion("home_no in", values, "homeNo");
            return (Criteria) this;
        }

        public Criteria andHomeNoNotIn(List<Integer> values) {
            addCriterion("home_no not in", values, "homeNo");
            return (Criteria) this;
        }

        public Criteria andHomeNoBetween(Integer value1, Integer value2) {
            addCriterion("home_no between", value1, value2, "homeNo");
            return (Criteria) this;
        }

        public Criteria andHomeNoNotBetween(Integer value1, Integer value2) {
            addCriterion("home_no not between", value1, value2, "homeNo");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andProjectDataIsNull() {
            addCriterion("project_data is null");
            return (Criteria) this;
        }

        public Criteria andProjectDataIsNotNull() {
            addCriterion("project_data is not null");
            return (Criteria) this;
        }

        public Criteria andProjectDataEqualTo(String value) {
            addCriterion("project_data =", value, "projectData");
            return (Criteria) this;
        }

        public Criteria andProjectDataNotEqualTo(String value) {
            addCriterion("project_data <>", value, "projectData");
            return (Criteria) this;
        }

        public Criteria andProjectDataGreaterThan(String value) {
            addCriterion("project_data >", value, "projectData");
            return (Criteria) this;
        }

        public Criteria andProjectDataGreaterThanOrEqualTo(String value) {
            addCriterion("project_data >=", value, "projectData");
            return (Criteria) this;
        }

        public Criteria andProjectDataLessThan(String value) {
            addCriterion("project_data <", value, "projectData");
            return (Criteria) this;
        }

        public Criteria andProjectDataLessThanOrEqualTo(String value) {
            addCriterion("project_data <=", value, "projectData");
            return (Criteria) this;
        }

        public Criteria andProjectDataLike(String value) {
            addCriterion("project_data like", value, "projectData");
            return (Criteria) this;
        }

        public Criteria andProjectDataNotLike(String value) {
            addCriterion("project_data not like", value, "projectData");
            return (Criteria) this;
        }

        public Criteria andProjectDataIn(List<String> values) {
            addCriterion("project_data in", values, "projectData");
            return (Criteria) this;
        }

        public Criteria andProjectDataNotIn(List<String> values) {
            addCriterion("project_data not in", values, "projectData");
            return (Criteria) this;
        }

        public Criteria andProjectDataBetween(String value1, String value2) {
            addCriterion("project_data between", value1, value2, "projectData");
            return (Criteria) this;
        }

        public Criteria andProjectDataNotBetween(String value1, String value2) {
            addCriterion("project_data not between", value1, value2, "projectData");
            return (Criteria) this;
        }

        public Criteria andProjectLanguageIsNull() {
            addCriterion("project_language is null");
            return (Criteria) this;
        }

        public Criteria andProjectLanguageIsNotNull() {
            addCriterion("project_language is not null");
            return (Criteria) this;
        }

        public Criteria andProjectLanguageEqualTo(String value) {
            addCriterion("project_language =", value, "projectLanguage");
            return (Criteria) this;
        }

        public Criteria andProjectLanguageNotEqualTo(String value) {
            addCriterion("project_language <>", value, "projectLanguage");
            return (Criteria) this;
        }

        public Criteria andProjectLanguageGreaterThan(String value) {
            addCriterion("project_language >", value, "projectLanguage");
            return (Criteria) this;
        }

        public Criteria andProjectLanguageGreaterThanOrEqualTo(String value) {
            addCriterion("project_language >=", value, "projectLanguage");
            return (Criteria) this;
        }

        public Criteria andProjectLanguageLessThan(String value) {
            addCriterion("project_language <", value, "projectLanguage");
            return (Criteria) this;
        }

        public Criteria andProjectLanguageLessThanOrEqualTo(String value) {
            addCriterion("project_language <=", value, "projectLanguage");
            return (Criteria) this;
        }

        public Criteria andProjectLanguageLike(String value) {
            addCriterion("project_language like", value, "projectLanguage");
            return (Criteria) this;
        }

        public Criteria andProjectLanguageNotLike(String value) {
            addCriterion("project_language not like", value, "projectLanguage");
            return (Criteria) this;
        }

        public Criteria andProjectLanguageIn(List<String> values) {
            addCriterion("project_language in", values, "projectLanguage");
            return (Criteria) this;
        }

        public Criteria andProjectLanguageNotIn(List<String> values) {
            addCriterion("project_language not in", values, "projectLanguage");
            return (Criteria) this;
        }

        public Criteria andProjectLanguageBetween(String value1, String value2) {
            addCriterion("project_language between", value1, value2, "projectLanguage");
            return (Criteria) this;
        }

        public Criteria andProjectLanguageNotBetween(String value1, String value2) {
            addCriterion("project_language not between", value1, value2, "projectLanguage");
            return (Criteria) this;
        }

        public Criteria andDevelopPlatformIsNull() {
            addCriterion("develop_platform is null");
            return (Criteria) this;
        }

        public Criteria andDevelopPlatformIsNotNull() {
            addCriterion("develop_platform is not null");
            return (Criteria) this;
        }

        public Criteria andDevelopPlatformEqualTo(String value) {
            addCriterion("develop_platform =", value, "developPlatform");
            return (Criteria) this;
        }

        public Criteria andDevelopPlatformNotEqualTo(String value) {
            addCriterion("develop_platform <>", value, "developPlatform");
            return (Criteria) this;
        }

        public Criteria andDevelopPlatformGreaterThan(String value) {
            addCriterion("develop_platform >", value, "developPlatform");
            return (Criteria) this;
        }

        public Criteria andDevelopPlatformGreaterThanOrEqualTo(String value) {
            addCriterion("develop_platform >=", value, "developPlatform");
            return (Criteria) this;
        }

        public Criteria andDevelopPlatformLessThan(String value) {
            addCriterion("develop_platform <", value, "developPlatform");
            return (Criteria) this;
        }

        public Criteria andDevelopPlatformLessThanOrEqualTo(String value) {
            addCriterion("develop_platform <=", value, "developPlatform");
            return (Criteria) this;
        }

        public Criteria andDevelopPlatformLike(String value) {
            addCriterion("develop_platform like", value, "developPlatform");
            return (Criteria) this;
        }

        public Criteria andDevelopPlatformNotLike(String value) {
            addCriterion("develop_platform not like", value, "developPlatform");
            return (Criteria) this;
        }

        public Criteria andDevelopPlatformIn(List<String> values) {
            addCriterion("develop_platform in", values, "developPlatform");
            return (Criteria) this;
        }

        public Criteria andDevelopPlatformNotIn(List<String> values) {
            addCriterion("develop_platform not in", values, "developPlatform");
            return (Criteria) this;
        }

        public Criteria andDevelopPlatformBetween(String value1, String value2) {
            addCriterion("develop_platform between", value1, value2, "developPlatform");
            return (Criteria) this;
        }

        public Criteria andDevelopPlatformNotBetween(String value1, String value2) {
            addCriterion("develop_platform not between", value1, value2, "developPlatform");
            return (Criteria) this;
        }

        public Criteria andAllNumberIsNull() {
            addCriterion("all_number is null");
            return (Criteria) this;
        }

        public Criteria andAllNumberIsNotNull() {
            addCriterion("all_number is not null");
            return (Criteria) this;
        }

        public Criteria andAllNumberEqualTo(Integer value) {
            addCriterion("all_number =", value, "allNumber");
            return (Criteria) this;
        }

        public Criteria andAllNumberNotEqualTo(Integer value) {
            addCriterion("all_number <>", value, "allNumber");
            return (Criteria) this;
        }

        public Criteria andAllNumberGreaterThan(Integer value) {
            addCriterion("all_number >", value, "allNumber");
            return (Criteria) this;
        }

        public Criteria andAllNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("all_number >=", value, "allNumber");
            return (Criteria) this;
        }

        public Criteria andAllNumberLessThan(Integer value) {
            addCriterion("all_number <", value, "allNumber");
            return (Criteria) this;
        }

        public Criteria andAllNumberLessThanOrEqualTo(Integer value) {
            addCriterion("all_number <=", value, "allNumber");
            return (Criteria) this;
        }

        public Criteria andAllNumberIn(List<Integer> values) {
            addCriterion("all_number in", values, "allNumber");
            return (Criteria) this;
        }

        public Criteria andAllNumberNotIn(List<Integer> values) {
            addCriterion("all_number not in", values, "allNumber");
            return (Criteria) this;
        }

        public Criteria andAllNumberBetween(Integer value1, Integer value2) {
            addCriterion("all_number between", value1, value2, "allNumber");
            return (Criteria) this;
        }

        public Criteria andAllNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("all_number not between", value1, value2, "allNumber");
            return (Criteria) this;
        }

        public Criteria andPronserNumberIsNull() {
            addCriterion("pronser_number is null");
            return (Criteria) this;
        }

        public Criteria andPronserNumberIsNotNull() {
            addCriterion("pronser_number is not null");
            return (Criteria) this;
        }

        public Criteria andPronserNumberEqualTo(Integer value) {
            addCriterion("pronser_number =", value, "pronserNumber");
            return (Criteria) this;
        }

        public Criteria andPronserNumberNotEqualTo(Integer value) {
            addCriterion("pronser_number <>", value, "pronserNumber");
            return (Criteria) this;
        }

        public Criteria andPronserNumberGreaterThan(Integer value) {
            addCriterion("pronser_number >", value, "pronserNumber");
            return (Criteria) this;
        }

        public Criteria andPronserNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("pronser_number >=", value, "pronserNumber");
            return (Criteria) this;
        }

        public Criteria andPronserNumberLessThan(Integer value) {
            addCriterion("pronser_number <", value, "pronserNumber");
            return (Criteria) this;
        }

        public Criteria andPronserNumberLessThanOrEqualTo(Integer value) {
            addCriterion("pronser_number <=", value, "pronserNumber");
            return (Criteria) this;
        }

        public Criteria andPronserNumberIn(List<Integer> values) {
            addCriterion("pronser_number in", values, "pronserNumber");
            return (Criteria) this;
        }

        public Criteria andPronserNumberNotIn(List<Integer> values) {
            addCriterion("pronser_number not in", values, "pronserNumber");
            return (Criteria) this;
        }

        public Criteria andPronserNumberBetween(Integer value1, Integer value2) {
            addCriterion("pronser_number between", value1, value2, "pronserNumber");
            return (Criteria) this;
        }

        public Criteria andPronserNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("pronser_number not between", value1, value2, "pronserNumber");
            return (Criteria) this;
        }

        public Criteria andCrtTimeIsNull() {
            addCriterion("crt_time is null");
            return (Criteria) this;
        }

        public Criteria andCrtTimeIsNotNull() {
            addCriterion("crt_time is not null");
            return (Criteria) this;
        }

        public Criteria andCrtTimeEqualTo(Date value) {
            addCriterionForJDBCDate("crt_time =", value, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("crt_time <>", value, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("crt_time >", value, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("crt_time >=", value, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeLessThan(Date value) {
            addCriterionForJDBCDate("crt_time <", value, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("crt_time <=", value, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeIn(List<Date> values) {
            addCriterionForJDBCDate("crt_time in", values, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("crt_time not in", values, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("crt_time between", value1, value2, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("crt_time not between", value1, value2, "crtTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterionForJDBCDate("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterionForJDBCDate("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterionForJDBCDate("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andLeaderIsNull() {
            addCriterion("leader is null");
            return (Criteria) this;
        }

        public Criteria andLeaderIsNotNull() {
            addCriterion("leader is not null");
            return (Criteria) this;
        }

        public Criteria andLeaderEqualTo(String value) {
            addCriterion("leader =", value, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderNotEqualTo(String value) {
            addCriterion("leader <>", value, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderGreaterThan(String value) {
            addCriterion("leader >", value, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderGreaterThanOrEqualTo(String value) {
            addCriterion("leader >=", value, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderLessThan(String value) {
            addCriterion("leader <", value, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderLessThanOrEqualTo(String value) {
            addCriterion("leader <=", value, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderLike(String value) {
            addCriterion("leader like", value, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderNotLike(String value) {
            addCriterion("leader not like", value, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderIn(List<String> values) {
            addCriterion("leader in", values, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderNotIn(List<String> values) {
            addCriterion("leader not in", values, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderBetween(String value1, String value2) {
            addCriterion("leader between", value1, value2, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderNotBetween(String value1, String value2) {
            addCriterion("leader not between", value1, value2, "leader");
            return (Criteria) this;
        }

        public Criteria andApproverIsNull() {
            addCriterion("approver is null");
            return (Criteria) this;
        }

        public Criteria andApproverIsNotNull() {
            addCriterion("approver is not null");
            return (Criteria) this;
        }

        public Criteria andApproverEqualTo(String value) {
            addCriterion("approver =", value, "approver");
            return (Criteria) this;
        }

        public Criteria andApproverNotEqualTo(String value) {
            addCriterion("approver <>", value, "approver");
            return (Criteria) this;
        }

        public Criteria andApproverGreaterThan(String value) {
            addCriterion("approver >", value, "approver");
            return (Criteria) this;
        }

        public Criteria andApproverGreaterThanOrEqualTo(String value) {
            addCriterion("approver >=", value, "approver");
            return (Criteria) this;
        }

        public Criteria andApproverLessThan(String value) {
            addCriterion("approver <", value, "approver");
            return (Criteria) this;
        }

        public Criteria andApproverLessThanOrEqualTo(String value) {
            addCriterion("approver <=", value, "approver");
            return (Criteria) this;
        }

        public Criteria andApproverLike(String value) {
            addCriterion("approver like", value, "approver");
            return (Criteria) this;
        }

        public Criteria andApproverNotLike(String value) {
            addCriterion("approver not like", value, "approver");
            return (Criteria) this;
        }

        public Criteria andApproverIn(List<String> values) {
            addCriterion("approver in", values, "approver");
            return (Criteria) this;
        }

        public Criteria andApproverNotIn(List<String> values) {
            addCriterion("approver not in", values, "approver");
            return (Criteria) this;
        }

        public Criteria andApproverBetween(String value1, String value2) {
            addCriterion("approver between", value1, value2, "approver");
            return (Criteria) this;
        }

        public Criteria andApproverNotBetween(String value1, String value2) {
            addCriterion("approver not between", value1, value2, "approver");
            return (Criteria) this;
        }

        public Criteria andProjectbudgetIsNull() {
            addCriterion("projectbudget is null");
            return (Criteria) this;
        }

        public Criteria andProjectbudgetIsNotNull() {
            addCriterion("projectbudget is not null");
            return (Criteria) this;
        }

        public Criteria andProjectbudgetEqualTo(Double value) {
            addCriterion("projectbudget =", value, "projectbudget");
            return (Criteria) this;
        }

        public Criteria andProjectbudgetNotEqualTo(Double value) {
            addCriterion("projectbudget <>", value, "projectbudget");
            return (Criteria) this;
        }

        public Criteria andProjectbudgetGreaterThan(Double value) {
            addCriterion("projectbudget >", value, "projectbudget");
            return (Criteria) this;
        }

        public Criteria andProjectbudgetGreaterThanOrEqualTo(Double value) {
            addCriterion("projectbudget >=", value, "projectbudget");
            return (Criteria) this;
        }

        public Criteria andProjectbudgetLessThan(Double value) {
            addCriterion("projectbudget <", value, "projectbudget");
            return (Criteria) this;
        }

        public Criteria andProjectbudgetLessThanOrEqualTo(Double value) {
            addCriterion("projectbudget <=", value, "projectbudget");
            return (Criteria) this;
        }

        public Criteria andProjectbudgetIn(List<Double> values) {
            addCriterion("projectbudget in", values, "projectbudget");
            return (Criteria) this;
        }

        public Criteria andProjectbudgetNotIn(List<Double> values) {
            addCriterion("projectbudget not in", values, "projectbudget");
            return (Criteria) this;
        }

        public Criteria andProjectbudgetBetween(Double value1, Double value2) {
            addCriterion("projectbudget between", value1, value2, "projectbudget");
            return (Criteria) this;
        }

        public Criteria andProjectbudgetNotBetween(Double value1, Double value2) {
            addCriterion("projectbudget not between", value1, value2, "projectbudget");
            return (Criteria) this;
        }

        public Criteria andDescribeprojectIsNull() {
            addCriterion("describeproject is null");
            return (Criteria) this;
        }

        public Criteria andDescribeprojectIsNotNull() {
            addCriterion("describeproject is not null");
            return (Criteria) this;
        }

        public Criteria andDescribeprojectEqualTo(String value) {
            addCriterion("describeproject =", value, "describeproject");
            return (Criteria) this;
        }

        public Criteria andDescribeprojectNotEqualTo(String value) {
            addCriterion("describeproject <>", value, "describeproject");
            return (Criteria) this;
        }

        public Criteria andDescribeprojectGreaterThan(String value) {
            addCriterion("describeproject >", value, "describeproject");
            return (Criteria) this;
        }

        public Criteria andDescribeprojectGreaterThanOrEqualTo(String value) {
            addCriterion("describeproject >=", value, "describeproject");
            return (Criteria) this;
        }

        public Criteria andDescribeprojectLessThan(String value) {
            addCriterion("describeproject <", value, "describeproject");
            return (Criteria) this;
        }

        public Criteria andDescribeprojectLessThanOrEqualTo(String value) {
            addCriterion("describeproject <=", value, "describeproject");
            return (Criteria) this;
        }

        public Criteria andDescribeprojectLike(String value) {
            addCriterion("describeproject like", value, "describeproject");
            return (Criteria) this;
        }

        public Criteria andDescribeprojectNotLike(String value) {
            addCriterion("describeproject not like", value, "describeproject");
            return (Criteria) this;
        }

        public Criteria andDescribeprojectIn(List<String> values) {
            addCriterion("describeproject in", values, "describeproject");
            return (Criteria) this;
        }

        public Criteria andDescribeprojectNotIn(List<String> values) {
            addCriterion("describeproject not in", values, "describeproject");
            return (Criteria) this;
        }

        public Criteria andDescribeprojectBetween(String value1, String value2) {
            addCriterion("describeproject between", value1, value2, "describeproject");
            return (Criteria) this;
        }

        public Criteria andDescribeprojectNotBetween(String value1, String value2) {
            addCriterion("describeproject not between", value1, value2, "describeproject");
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