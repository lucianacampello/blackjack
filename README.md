# blackjack

A Clojure library designed to ... well, that part is up to you.

### Regras do Jogo
As cartas J, Q e K valem: 10 pontos

A pontuação da carta A depende da mão do jogador. A carta vale 11 pontos, porém se a pontuação da mão
do jogador passar de 21, esta carta valerá apenas 1 ponto.

Exemplo: 

cartas [A 10] => A (11 pontos) + 10 = 21;

cartas [A 7 5] => A (11 pontos) + 7 + 5 = 23, porém como estorou 21, a carta A vale 1, então fica: 1 + 7 + 5 = 13.  
 

## Usage

FIXME

## License

Copyright © 2023 FIXME

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
