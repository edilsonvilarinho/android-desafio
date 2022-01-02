# Desafio Android

<img src="https://github.com/edilsonvilarinho/android-desafio/blob/main/images/Android-Emulator-Pixel_4_XL_API_31_5554-2021-12-28-23-56-38.gif" width="300"/>

Um dos desafios de qualquer time de desenvolvimento é lidar com código legado e no PicPay isso não é diferente. Um dos objetivos de trazer os melhores desenvolvedores do Brasil é atacar o problema. Para isso, essa etapa do processo consiste numa proposta de solução para o desafio abaixo e você pode escolher a melhor forma de resolvê-lo, de acordo com sua comodidade e disponibilidade de tempo:
- Resolver o desafio previamente, e explicar sua abordagem no momento da entrevista.
- Discutir as possibilidades de solução durante a entrevista, fazendo um pair programming (bate-papo) interativo com os nossos devs.

Com o passar do tempo identificamos alguns problemas que impedem esse aplicativo de escalar e acarretam problemas de experiência do usuário. A partir disso elaboramos a seguinte lista de requisitos que devem ser cumpridos ao melhorar nossa arquitetura:

- :heavy_check_mark: Em mudanças de configuração o aplicativo perde o estado da tela. Gostaríamos que o mesmo fosse mantido.
- :heavy_check_mark: Nossos relatórios de crash têm mostrado alguns crashes relacionados a campos que não deveriam ser nulos sendo nulos e gerenciamento de lifecycle. Gostaríamos que fossem corrigidos.
- :heavy_check_mark: Gostaríamos de cachear os dados retornados pelo servidor.
- :heavy_check_mark: Haverá mudanças na lógica de negócios e gostaríamos que a arquitetura reaja bem a isso.
- :heavy_check_mark: Haverá mudanças na lógica de apresentação. Gostaríamos que a arquitetura reaja bem a isso.
- :x: Com um grande número de desenvolvedores e uma quantidade grande de mudanças ocorrendo testes automatizados são essenciais.
  - :x: Gostaríamos de ter testes unitários testando nossa lógica de apresentação, negócios e dados independentemente, visto que tanto a escrita quanto execução dos mesmos são rápidas.
  - :x: Por outro lado, testes unitários rodam em um ambiente de execução diferenciado e são menos fiéis ao dia-a-dia de nossos usuários, então testes instrumentados também são importantes.

Boa sorte! =)

Ps.: Fique à vontade para editar o projeto inteiro, organização de pastas e módulos, bem como as dependências utilizadas
