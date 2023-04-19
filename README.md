# DersTakipSistemiTestOtomasyonu
Bu proje, üniversitenin uzaktan eğitim sistemine otomatik olarak giriş yaparak ders saatlerinde kamera ve mikrofonu kapattıktan sonra derse bağlanıp 1 saat sonra dersten otomatik olarak çıkışını yapmanızı sağlar. Jenkins ile ayarladığınız gün ve saatlerde otomatik olarak çalışır.

Gereksinimler

Projenin çalışması için aşağıdaki programlara ihtiyaç duyulmaktadır:

    Java JDK
    Maven
    Jenkins
    Selenium WebDriver

Kurulum

    Java JDK'yi bilgisayarınıza kurun.
    Maven'i bilgisayarınıza kurun.
    Jenkins'i bilgisayarınıza kurun.
    Selenium WebDriver'ı projenize dahil edin.

Kullanım

    Projenin bulunduğu klasöre gidin.
    mvn test komutunu kullanarak projeyi çalıştırın.

Jenkins Entegrasyonu

    Jenkins entegrasyonumuzu pipeline şekilde kuruyoruz çünkü:
    Aynı proje altında birden fazla derslerimiz var ve hepsinin saatleri ve günleri farklı tek bir proje altındaki testleri
    farklı zamanlarda koşturabilmek için pipeline kullanıyoruz.

    Jenkins ana sayfasına giriş yapın ve "New Item" seçeneğine tıklayın.
    Açılan sayfada "item name" alanına "MyJavaPipeline" yazın ve "Pipeline" seçeneğini seçin, ardından "OK" butonuna tıklayın.
    Açılan sayfada "Pipeline" bölümünü bulun ve "Definition" seçeneğini "Pipeline script" olarak ayarlayın.
    "Script" bölümüne aşağıdaki scripti yapıştırın:

        *************************************************************************************
        pipeline {
        agent any
        triggers {
            cron('00 17 * * 3')
        }
        stages {
            stage('Checkout') {
                steps {
                    git branch: 'main', url: 'https://github.com/onlyfatih/DersTakipSistemiTestOtomasyonu.git'
                }
            }
            stage('Build and Test') {
                steps {
                    sh 'mvn clean test -Dtest=AlgoritmaAnaliziLoginTests'
                }
            }
        }
        }

        pipeline {
            agent any
            triggers {
                cron('00 15 * * 4')
            }
            stages {
                stage('Checkout') {
                    steps {
                        git branch: 'main', url: 'https://github.com/onlyfatih/DersTakipSistemiTestOtomasyonu.git'
                    }
                }
                stage('Build and Test') {
                    steps {
                        sh 'mvn clean test -Dtest=ParalelProgramlamaLoginTests'
                    }
                }
            }
        }
        *************************************************************************************
        
    "Save" butonuna tıklayarak projeyi kaydedin.
    Jenkins ana sayfasındaki "MyJavaPipeline" projesine tıklayarak, proje sayfasına gidin.
    "Build Now" butonuna tıklayarak projeyi çalıştırın.
    Testlerinizin başarıyla koştuğundan emin olmak için, proje sayfasındaki "Console Output" bölümüne bakabilirsiniz.

Katkıda Bulunma

    Bu projeye katkıda bulunmak için lütfen pull request gönderin.
Lisans

    Bu proje MIT lisansı altında lisanslanmıştır. Detaylı bilgi için LICENSE dosyasına bakabilirsiniz.
