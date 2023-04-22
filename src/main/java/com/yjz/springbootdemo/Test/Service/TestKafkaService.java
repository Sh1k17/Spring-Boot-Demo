package com.yjz.springbootdemo.Test.Service;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

/**
 * 消费者
 * kafka监听器
 */
@Component
@Slf4j
public class TestKafkaService {

    /**
     * kafka的监听器1，topic为"topic_test"，消费者组为"group_topic_test"
     * @param record
     * @param item
     */
    @KafkaListener(topics = "test", groupId = "test_group")
    public void topicListener1(ConsumerRecord<String, String> record, Acknowledgment item) {
        String value = record.value();
        log.info(value);
        log.info(String.valueOf(record));
        //手动提交
        item.acknowledge();
    }

    /**
     * 配置多个消费组
     * kafka的监听器2，topic为"topic_test2"，消费者组为"group_topic_test"
     * @param record
     * @param item
     */
    @KafkaListener(topics = "topic_test",groupId = "test_group")
    public void topicListener2(ConsumerRecord<String, String> record, Acknowledgment item) {
        String value = record.value();
        log.info(value);
        log.info(String.valueOf(record));
        item.acknowledge();
    }

}
