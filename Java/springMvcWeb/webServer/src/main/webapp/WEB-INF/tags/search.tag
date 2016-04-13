<style>
    #search{
        width: 480px;
        height: 45px;
        border: 2px solid #3072CF;
    }
    #search-box{
        outline: none;
        float: left;
        width: 390px;
        height: 36px;
        line-height: 40px;
        border: none;
        font-size: 14px;
        color: #999;
        padding-left: 10px;
        overflow: hidden;
    }
    #search-box-submit{
        cursor: pointer;
        float: right;
        width: 55px;
        height: 41px;
        background: url("images/search.jpg") 0px 0px no-repeat;
        border: none;
    }
</style>

<div class="row" style="background-image: url('images/title_bg.jpg');">
    <div class="col-sm-3">
    </div>
    <div id="main" class="col-sm-6">
        <div id="search">
            <input type="text" name="q" class="" id="search-box" placeholder="请输入要搜索的游戏" autocomplete="off" />
            <input type="submit" class="" id="search-box-submit" value/>
        </div>
    </div>
    <div class="col-sm-3">
    </div>
</div>