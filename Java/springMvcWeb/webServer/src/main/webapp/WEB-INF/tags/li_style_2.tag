<%@ attribute name="text" required="true" type="java.lang.String" description="" %>
<%@ attribute name="link" required="true" type="java.lang.String" description="" %>
<style>
    li.style2{
        border-bottom: 1px #ddd solid;
        height: 39px;
        line-height: 40px;
        white-space: nowrap;
    }

    li.style2 a{
        color: #333;
        text-decoration: none;
        cursor: auto;
    }
</style>

<li class="style2">
    <a class="" target="_blank" href="${link}">${text}</a>
</li>
