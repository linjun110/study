package com.linjun.language.java.model;

import java.util.List;

public class Template {
    private String id;

    private List<ConfigRuleGroup> configRuleGroups;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<ConfigRuleGroup> getConfigRuleGroups() {
        return configRuleGroups;
    }

    public void setConfigRuleGroups(List<ConfigRuleGroup> configRuleGroups) {
        this.configRuleGroups = configRuleGroups;
    }



}
