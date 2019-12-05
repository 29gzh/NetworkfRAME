package com.heng.common_base.eventbus

import com.heng.common_base.bean.NoArg

/**
 * @author ziheng
 * @date   2019/12/5.
 * @function
 */

@NoArg
data class EventMessageBean (
    var tag: String,

    var messageInt: Int,

    var messageStr: String,

    var messageBool: Boolean,

    var messageLong: Long

)










