<?php

/**
 *      [Discuz!] (C)2001-2099 Comsenz Inc.
 *      This is NOT a freeware, use is subject to license terms
 *
 *      $Id: member.php 34253 2013-11-25 03:36:23Z nemohou $
 */

define('APPTYPEID', 0);
define('CURSCRIPT', 'member');

require './source/class/class_core.php';

$discuz = C::app();

/**
 * 支持的query string.
 * ?mod=register
 * ...
 */
$modarray = array('activate', 'emailverify', 'getpasswd',
	'groupexpiry', 'logging', 'lostpasswd',
	'register', 'regverify', 'switchstatus');

/**
 * 默认到register页面
 *DISCUZ_ROOT = /Users/linjun/study/Discuz/upload/;
 */
$mod = !in_array($discuz->var['mod'], $modarray) && (!preg_match('/^\w+$/', $discuz->var['mod']) || !file_exists(DISCUZ_ROOT.'./source/module/member/member_'.$discuz->var['mod'].'.php')) ? 'register' : $discuz->var['mod'];

define('CURMODULE', $mod);
//print DISCUZ_ROOT;

$discuz->init();
if($mod == 'register' && $discuz->var['mod'] != $_G['setting']['regname']) {
    /**
     * TODO: showmessage definition
     */
	showmessage('undefined_action');
}
//print_r ($_G['setting']);


/**
 * TODO: libfile definition
 * libfile对String进行字面的转换
 * 1. source/function/function_member.php
 * 2. source/class/class_member.php
 */
require libfile('function/member');
require libfile('class/member');
runhooks();


require DISCUZ_ROOT.'./source/module/member/member_'.$mod.'.php';

?>
