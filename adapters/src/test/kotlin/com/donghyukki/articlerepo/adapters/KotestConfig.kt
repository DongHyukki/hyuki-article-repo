package com.donghyukki.articlerepo.adapters

import io.kotest.core.config.AbstractProjectConfig
import io.kotest.core.spec.IsolationMode

class KotestConfig : AbstractProjectConfig() {

    override val isolationMode: IsolationMode = IsolationMode.InstancePerLeaf
}
