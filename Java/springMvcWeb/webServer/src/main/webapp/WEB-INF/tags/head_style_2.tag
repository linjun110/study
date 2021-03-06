<%@ attribute name="head" required="true" type="java.lang.String" description="" %>
<%@ attribute name="link" required="true" type="java.lang.String" description="" %>

<style>
    .head_style_2{
        background-color: #fff;
        padding-bottom: 5px;
        margin-top: 15px;
        box-shadow: 2px 2px 2px #cdcdcd;
    }

    .head_style_2 .head{
        width: 280px;
        margin-left: auto;
        margin-right: auto;
        padding-top: 5px;
        line-height: 40px;
        height: 45px;
        border-bottom: 1px #ddd solid;
    }

    .head_style_2 .head > p{
        margin-bottom: 0px;
    }

    .head_style_2 .head .spec{
        color: #333;
        font-weight: bold;
        font-size: 16px;
    }

    .head_style_2 .head .link{
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

    .head_style_2 a:visited{
        text-decoration: none;
    }
</style>
<div class="head_style_2">
    <div class="head">
            <p>
                <a class="link">${link}</a>
                <strong class="spec">${head}</strong>
            </p>
    </div>
</div>