<%@ attribute name="image_src" required="true" type="java.lang.String" description="image src" %>
<%@ attribute name="title" required="true" type="java.lang.String" description="title" %>
<%@ attribute name="text" required="true" type="java.lang.String" description="text" %>
<style>
    li.style3{
        width: 280px;
        margin-left: auto;
        margin-right: auto;
        margin-top: 0px;
        padding-top: 20px;
        list-style: none;
        overflow: hidden;
        border-bottom: 1px solid #cdcdcd;
    }

    li.style3 a.image img{
        height: 160px;
        width: 280px;
    }

    li.style3 p.title{
        margin: 0px 0px 10px;
        overflow: hidden;
        text-overflow: ellipsis;
        line-height: 18px;
        margin-top: 15px;
        margin-bottom: 5px;
        white-space: nowrap;
        padding-left: 15px;
        font-size: 12px;
    }

    li.style3 p.title a{
        color: #333;
        text-decoration: none;
        cursor: auto;
        line-height: 18px;
        white-space: nowrap;
        list-style: none;
        font-size: 14px;
        font-weight: bold;
    }

    li.style3 > a{
        color: #333;
        text-decoration: none;
        cursor: auto;
    }

    li.style3 > a > p{
        color: #999;
    }

    li.style3 a:visited{
        text-decoration: none;
    }
</style>
<li class="style3">
    <a class="image">
        <img src='${image_src}'/>
    </a>
    <p class="title">
        <a>
            ${title}
        </a>
    </p>
    <a>
        <p>
            ${text}
        </p>
    </a>
</li>