/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.rng.core.source32;

import org.apache.commons.rng.core.RandomAssert;
import org.junit.jupiter.api.Test;

class Well512aTest {
    /** The size of the array seed. */
    private static final int SEED_SIZE = 16;

    @Test
    void testReferenceCode() {
        final Well512a rng = new Well512a(new int[] {
            0x2c2878c6, 0x47af36c4, 0xf422e677, 0xf08fd8d3, 0xee9a47c7, 0xba983942, 0xa2a9f9a5, 0x1d443748,
            0x8fc260b2, 0x5275c681, 0x4a2f5a28, 0x2911683d, 0xa204c27e, 0xb20a6a26, 0x54ba33be, 0x67d63eb0
        });

        final int[] expectedSequence = {
            0x61714569, 0x6fdd4898, 0xc5f47050, 0x810a6b1c, 0xc1af8b8c, 0x92a98227, 0x64cb1d8d, 0x24578071,
            0x793b296a, 0x212298db, 0x0065f1a0, 0x74b6a737, 0x6f40110d, 0xa84d2dfb, 0x7a23fc8a, 0xf4895b35,
            0x85732a6e, 0x30550ad9, 0x53bf4e25, 0xd16e0c02, 0x3c5dd4e7, 0xc1b55438, 0x2b6a28a4, 0x57d400ec,
            0x115082ee, 0x13788a09, 0x784cd04b, 0x90240346, 0x49e86af5, 0x574c6790, 0x78b55a42, 0xf9f4cc61,
            0x52b9b459, 0x0c92fddf, 0x5170fd1e, 0xe39997a7, 0x09215785, 0xa02d7d5d, 0xe1cbb539, 0x0110f5e2,
            0x12b53330, 0xebb4504e, 0x22f816af, 0x4a2158af, 0x2ce457f5, 0xd9733322, 0xd3f0dc69, 0xf379d207,
            0x915a36ba, 0xda8d94ca, 0x93f2e50b, 0x546ad758, 0x40407b6a, 0xcd862700, 0x523ed8a9, 0xdd6b1ad0,
            0xffe3a271, 0x0c917702, 0x11a22e90, 0x58f9efd1, 0xaba08480, 0xeb71b156, 0x8c338ac3, 0x5c5ba7f6,
            0xe8c8046f, 0x12bb238a, 0x00b3d31c, 0xb1d02bc8, 0x667db6d9, 0xd26cf82b, 0x4d4b6dea, 0xc4b5f996,
            0x2eb8abe3, 0x193130c0, 0x171ae727, 0x48b2f7e9, 0x7fd0393c, 0xce46ebf6, 0xc2377f2a, 0x37c8d867,
            0xde1bafe6, 0x4f200655, 0xdce597c6, 0x71d94a5a, 0xfd90a771, 0xf525efbe, 0x4da61ac2, 0x2043c247,
            0x9dcf808e, 0x2ffebfb3, 0x99689f79, 0x5a829736, 0xc7371b28, 0xe62cba9c, 0x1e6106f6, 0xd1abf44e,
            0x4c29d5ba, 0x10ee5570, 0x37cadeda, 0x7967a7ff, 0x749c7c0a, 0xb948ed30, 0x112768c8, 0x7f46436b,
            0x2af1be27, 0x5972c9f0, 0xef3642f9, 0xb3d43956, 0x9ee7e9de, 0x4a13d96f, 0x86f5f652, 0x57d97072,
            0x1a4647ed, 0xaf1d4e0d, 0x01b11b4c, 0x5f87bcd0, 0xd9c4026e, 0xdbb29175, 0x25e7a68c, 0x57caa480,
            0x58079f5b, 0xd36ad1d6, 0xa13561e1, 0xcb4b8944, 0xe8c518fb, 0x84cc51c7, 0x40cbe128, 0xb64d53ae,
            0x01e30df7, 0x6d6acb68, 0xe4142fda, 0x80e2998c, 0xe61863ad, 0x0f657837, 0x6e6228e9, 0x9ed60ce9,
            0xafdac4e7, 0x755fabf7, 0x24ec4206, 0xf59afad0, 0x0c5dd31f, 0x9f736292, 0x4f275f0a, 0xfafebf4e,
            0x1a94af26, 0x958848f3, 0x005fd078, 0xdd5eea29, 0x5c6cf930, 0x77994735, 0x106f8cd7, 0x1b2912e7,
            0x78613865, 0x427de838, 0xb1bb6096, 0xe13b3537, 0x04655f8d, 0xad998410, 0x17c1feb4, 0x4eabe4b0,
            0xa0e57f92, 0x5d658608, 0x988b897c, 0xa6062a85, 0x56e9f7d8, 0xdf40e295, 0xdb1d72e0, 0x5a65da93,
            0x714b40c3, 0xa952a890, 0x398cbcef, 0x1d1bb4f9, 0x9094d514, 0xcfae96f0, 0x853f9e65, 0x56b44baf,
            0x4f38c51d, 0xf2291fd4, 0xc4b18d31, 0x6ea0056e, 0xe50dd70c, 0x5d51a093, 0x2d4a45da, 0x49fecc33,
            0xad1f5301, 0x7403b755, 0x86dd42e5, 0x28bff1a9, 0x35ff1b42, 0x7636ebc2, 0x07273732, 0x1f5a65e1,
            0x8bf4f088, 0x0c3820bb, 0xb214f04c, 0x7f042fd2, 0x7a5c38a1, 0x0b50b9ab, 0x6aa9449f, 0x1835a535,
            0xbbbdd7d5, 0x0081d11b, 0x4c205acf, 0x58f78f22, 0x77cb6a1b, 0x9effab72, 0xcd4683d9, 0x93075934,
            0x74fb3e2a, 0x7f93e2af, 0x0e1f57fd, 0xebe628f4, 0x4b4e3ee7, 0x1ecd5d44, 0xebfcff9f, 0x52edfbe1,
            0x1b2db0f1, 0xa91fc938, 0xd8cdb99f, 0x1cf26705, 0x6907c2f7, 0x47389180, 0x30bf2bb9, 0x13245cd2,
            0x07d1548e, 0x114d497e, 0x902066bc, 0x9679d297, 0x4cfc4c1d, 0xc42d9fa2, 0xa1cfe127, 0x5a9fcc85,
            0xe8352005, 0xfe8cfa54, 0x1b0c8554, 0xd8b570cd, 0xf3bdecf1, 0x1bcea156, 0x5617c091, 0x46383f89,
            0xbb057aa6, 0xdc183254, 0xae4d4105, 0x60415d33, 0x6545c6ab, 0x6f25e281, 0x709080d6, 0x9967e49e,
            0x6c0cc73f, 0x27dd6ad3, 0xee47d20f, 0x7ef804a5, 0xba4908fc, 0x36692450, 0x871b5058, 0x4a308706
        };

        RandomAssert.assertEquals(expectedSequence, rng);
    }

    @Test
    void testConstructorWithZeroSeedIsNonFunctional() {
        RandomAssert.assertNextIntZeroOutput(new Well512a(new int[SEED_SIZE]), 2 * SEED_SIZE);
    }

    @Test
    void testConstructorWithSingleBitSeedIsFunctional() {
        RandomAssert.assertIntArrayConstructorWithSingleBitSeedIsFunctional(Well512a.class, SEED_SIZE);
    }
}
