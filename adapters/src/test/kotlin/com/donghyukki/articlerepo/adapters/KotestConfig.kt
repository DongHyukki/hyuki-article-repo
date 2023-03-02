package com.donghyukki.articlerepo.adapters

import io.kotest.core.config.AbstractProjectConfig
import io.kotest.core.spec.IsolationMode

class KotestConfig : AbstractProjectConfig() {
    // override fun extensions() = listOf(SpringExtension)
    override val isolationMode: IsolationMode = IsolationMode.InstancePerLeaf
}
