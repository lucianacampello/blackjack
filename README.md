# Blackjack Game
### Game Rules
Cards **2 through 10** are worth their face value, and **face cards (jack, queen, king)** are also worth 10.

An **ace's(A)** value is 11 unless this causes the score to exceed 21 points, in which case it is worth 1.

#### Example: 

**Cards [7 K]**

    7 + K(10) = 17;

**Cards [A 1 9]** 

    A (11 points) + 1 + 9 = 21;

**Cards [A 7 5]** 

    A (11 points) + 7 + 5 = 23 but it burst 21, the ace (A) card worth 1, so the score is: 1 + 7 + 5 = 13.  

## Usage

<img src='./resources/img/construction.png' alt='in construction' width='100' />

## Technologies
* Clojure 1.11
* Leiningen 2.10.0

## Reference

[![Blackjack Game](https://img.youtube.com/vi/f_I89ICI3x8/0.jpg)](https://www.youtube.com/watch?v=f_I89ICI3x8&list=PLcjDvROHY58MlqcAU7d0fYhAJQ-p-dMp6&index=1&ab_channel=CesarAlcancio)

## License

Copyright © 2023

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
