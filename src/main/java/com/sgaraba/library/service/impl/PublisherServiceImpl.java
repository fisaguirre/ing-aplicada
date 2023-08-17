package com.sgaraba.library.service.impl;

import com.sgaraba.library.domain.Publisher;
import com.sgaraba.library.repository.PublisherRepository;
import com.sgaraba.library.service.PublisherService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Publisher}.
 */
@Service
@Transactional
public class PublisherServiceImpl implements PublisherService {

    private final Logger log = LoggerFactory.getLogger(PublisherServiceImpl.class);

    private final PublisherRepository publisherRepository;

    public PublisherServiceImpl(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Override
    public Publisher save(Publisher publisher) {
        log.debug("Request to save Publisher : {}", publisher);
        return publisherRepository.save(publisher);
    }

    @Override
    public Publisher update(Publisher publisher) {
        log.debug("Request to update Publisher : {}", publisher);
        return publisherRepository.save(publisher);
    }

    @Override
    public Optional<Publisher> partialUpdate(Publisher publisher) {
        log.debug("Request to partially update Publisher : {}", publisher);

        return publisherRepository
            .findById(publisher.getId())
            .map(existingPublisher -> {
                if (publisher.getName() != null) {
                    existingPublisher.setName(publisher.getName());
                }

                return existingPublisher;
            })
            .map(publisherRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Publisher> findAll(Pageable pageable) {
        log.debug("Request to get all Publishers");
        return publisherRepository.findAll(pageable);
    }

    /**
     *  Get all the publishers where Book is {@code null}.
     *  @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<Publisher> findAllWhereBookIsNull() {
        log.debug("Request to get all publishers where Book is null");
        return StreamSupport
            .stream(publisherRepository.findAll().spliterator(), false)
            .filter(publisher -> publisher.getBook() == null)
            .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Publisher> findOne(Long id) {
        log.debug("Request to get Publisher : {}", id);
        return publisherRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Publisher : {}", id);
        publisherRepository.deleteById(id);
    }
}
