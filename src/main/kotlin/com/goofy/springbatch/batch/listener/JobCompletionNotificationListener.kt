package com.goofy.springbatch.batch.listener

import com.goofy.springbatch.application.ItemService
import mu.KotlinLogging
import org.springframework.batch.core.BatchStatus
import org.springframework.batch.core.JobExecution
import org.springframework.batch.core.listener.JobExecutionListenerSupport
import org.springframework.stereotype.Component

@Component
class JobCompletionNotificationListener(
    private val itemService: ItemService
) : JobExecutionListenerSupport() {
    private val logger = KotlinLogging.logger {}

    override fun afterJob(jobExecution: JobExecution) {
        if (jobExecution.status == BatchStatus.COMPLETED) {
            val item = itemService.save("hello")
            logger.info { "afterJob : ${item.name}" }
        }
    }

    override fun beforeJob(jobExecution: JobExecution) {
        super.beforeJob(jobExecution)
    }
}
