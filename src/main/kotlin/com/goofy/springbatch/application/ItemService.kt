package com.goofy.springbatch.application

import com.goofy.springbatch.domain.Item
import com.goofy.springbatch.infrastructure.ItemRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ItemService(
    private val itemRepository: ItemRepository
) {
    @Transactional
    fun save(name: String) {
        itemRepository.save(Item(name = name))
    }
}
