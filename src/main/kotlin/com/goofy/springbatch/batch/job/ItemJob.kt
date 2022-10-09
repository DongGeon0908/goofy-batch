package com.goofy.springbatch.batch.job

import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.context.annotation.Configuration

@Configuration
class ItemJob(
    private val jobBuilderFactory: JobBuilderFactory,
    private val stepBuilderFactory: JobBuilderFactory
) {

}
