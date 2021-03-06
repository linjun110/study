<%@ attribute name="link" required="true" type="java.lang.String" description="" %>
<%@ attribute name="img_src" required="true" type="java.lang.String" description="" %>
<%@ attribute name="title" required="true" type="java.lang.String" description="" %>
<%@ attribute name="text" required="true" type="java.lang.String" description="" %>

<style>
    li.style1{
        padding-top: 10px;
        border-bottom: 1px #ddd solid;
        height: 80px;
    }

    li.style1 img{
        margin-right: 20px;
        float: left;
    }

    li.style1 > p{
        white-space: nowrap;
        line-height: 20px;
    }

    li.style1 > p > a{
        font-weight: bold;
        text-decoration: none;
        font-size: 14px;
        color: #333;
    }

    li.style1 > a{
        text-decoration: none;
        font-size: 12px;
        color: #333;
    }

    li.style1 > a > p{
        margin-top: 5px;
        color: #999;
    }
</style>

<li class="style1">
    <a target="_blank" href="${link}">
        <img src="${img_src}" alt="" class="" height="60" width="80">
    </a>
    <p class="">
        <a target="_blank" href="${link}" class="">${title}</a>
    </p>
    <a target="_blank" href="${link}">
        <p class="">${text}</p>
    </a>
</li>
