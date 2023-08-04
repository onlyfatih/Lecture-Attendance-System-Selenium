# Ders Takip Sistemi Test Otomasyonu
Bu proje, üniversitenin uzaktan eğitim sistemine otomatik olarak giriş yaparak ders saatlerinde kamera ve mikrofonu kapattıktan sonra derse bağlanıp 1 saat sonra dersten otomatik olarak çıkışını yapmanızı sağlar. Jenkins ile ayarladığınız gün ve saatlerde otomatik olarak çalışır.

<p align="center">
  <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/7/76/Konya_Teknik_%C3%9Cniversitesi_logo.svg/1024px-Konya_Teknik_%C3%9Cniversitesi_logo.svg.png" alt="Proje Logo" width="300" />
</p>

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
            cron('00 17 * * 3') // cron ifadesi "00 17 * * 3" dakika 00, saat 17:00, her ayın her günü ve haftanın 3. günü (çarşamba) anlamına gelir.
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
                cron('00 15 * * 4') // cron ifadesi "00 15 * * 4" dakika 00, saat 15:00, her ayın her günü ve haftanın 4. günü (perşembe) anlamına gelir.
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
