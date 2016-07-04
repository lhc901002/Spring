在多线程更新数据库时，如果更新的字段为整形，应该尽可能使用column=column+1，这样不会导致更新被其他线程覆盖，否则就得在service方法调用时加synchronized锁！
isolation = Isolation.READ_COMMITTED 只能保证每个线程读取的数据都是最新的，不能保证每个线程在其他线程更新完成后再读取，这样会导致多个线程读到相同的值。