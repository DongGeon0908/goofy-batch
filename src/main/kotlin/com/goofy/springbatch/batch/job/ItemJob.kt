package com.goofy.springbatch.batch.job

import com.goofy.springbatch.batch.listener.JobCompletionNotificationListener
import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.launch.support.RunIdIncrementer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ItemJob(
    private val jobBuilderFactory: JobBuilderFactory,
    private val stepBuilderFactory: JobBuilderFactory
) {
    @Bean
    fun job(listener: JobCompletionNotificationListener, step: Step): Job {
        return jobBuilderFactory.get("job")
            .incrementer(RunIdIncrementer())
            .listener(listener)
            .flow(step)
            .end()
            .build()
    }
}
