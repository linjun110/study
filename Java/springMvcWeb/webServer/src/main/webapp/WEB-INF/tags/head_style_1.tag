<%@ attribute name="head" required="true" type="java.lang.String" description="" %>
<%@ attribute name="link" required="true" type="java.lang.String" description="" %>
<%@ attribute name="style_bg_color" type="java.lang.String" description="" %>

<style>
    .head_style_1{
        background-color: #fff;
        margin-top: 15px;
        box-shadow: 2px 2px 2px #cdcdcd;
    }

    .head_style_1 .head{
        background-color: #51bee9;
        line-height: 40px;
        height: 40px;
    }

    .head_style_1 .head .spec{
        border-left: 5px #fff solid;
        color: #fff;
        font-weight: bold;
        font-size: 16px;
        margin-left: 20px;
        padding-left: 15px;
    }

    .head_style_1 .head .link{
        background-color: #e5e5e5;
        border-radius: 4px;
        color: #666;
        display: inline-block;
        height: 20px;
        line-height: 20px;
        text-align: center;
        width: 45px;
        cursor: pointer;
        float: right;
        margin-right: 20px;
        margin-top: 10px;
        text-decoration: none;
    }
</style>
<div class="head_style_1">
    <div class="head" style="background-color: ${style_bg_color};">
        <a class="link">${link}</a>
        <strong class="spec">${head}</strong>
    </div>
</div>
