package gormdemo


import org.grails.orm.hibernate.HibernateDatastore

class GormDemo {

    static void main(args) {
        Map configuration = [
                'hibernate.hbm2ddl.auto': 'create-drop',
                'dataSource.url'        : 'jdbc:h2:mem:myDB',
                'dataSource.logSql'     : true
        ]
        new HibernateDatastore(configuration, Foo, Bar)

        Foo.withNewSession {
            println new Foo(bar: new Bar(name: 'jeff')).save()
        }

    }
}