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
package org.apache.commons.rng.core.source64;

import org.apache.commons.rng.core.RandomAssert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MersenneTwister64Test {
    @Test
    void testMakotoNishimura() {
        final MersenneTwister64 rng = new MersenneTwister64(new long[] {0x12345L, 0x23456L, 0x34567L, 0x45678L});

        /*
         * Data from
         *   http://www.math.sci.hiroshima-u.ac.jp/~m-mat/MT/mt19937-64.out.txt
         * converted to hexadecimal.
         */
        final long[] expectedSequence = {
            0x64d79b552a559d7fL, 0x44a572665a6ee240L, 0xeb2bf6dc3d72135cL, 0xe3836981f9f82ea0L,
            0x43a38212350ee392L, 0xce77502bffcacf8bL, 0x5d8a82d90126f0e7L, 0xc0510c6f402c1e3cL,
            0x48d895bf8b69f77bL, 0x8d9fbb371f1de07fL, 0x1126b97be8c91ce2L, 0xf05e1c9dc2674be2L,
            0xe4d5327a12874c1eL, 0x7c1951ea43a7500dL, 0xbba2bbfbecbc239aL, 0xc5704350b17f0215L,
            0x823a67c5f88337e7L, 0xd9bf140bfeb4c1a9L, 0x9fbe3cfcd1f08059L, 0xdc29309412e352b9L,
            0x5a0ff7908b1b3c57L, 0x46f39cb43b126c55L, 0x9648168491f3b126L, 0xdd3e72538fd39a1cL,
            0xd65a3663fc9b0898L, 0x421ee7823c2af2ebL, 0xcba3a4b69b6ed152L, 0x0348399b7d2b8428L,
            0xbdb750bf00c34a38L, 0xcf36d95eae514f52L, 0x7b9231d5308d7534L, 0xb225e28cfc5aa663L,
            0xa833f6d5c72448a4L, 0xdaa565f5815de899L, 0x4b051d1e4cc78eb8L, 0x97fcd1b4d342e575L,
            0xef6a48be001729c7L, 0x3982f1fa31afeab8L, 0xfdc570ba2fe979fbL, 0xb57697121dfdfe93L,
            0x96524e209b767c29L, 0x55aad0ebca994043L, 0xb22687b88856b63eL, 0xb313b667a4d999d6L,
            0x07c7fa1bd6fd7deaL, 0x0ee9f4c15c57e92aL, 0xc5fb71b8f4bf5f56L, 0xa251f93a4b335492L,
            0xb9bad7f9e5b07befL, 0x62fc9ac35ccde7aaL, 0x933792382b0218a3L, 0x7d497d2f7a15eaf8L,
            0xb2f0624214f522a2L, 0xd9895bbb810ec3d6L, 0x22d91b683f251121L, 0xc8fe9a347247affdL,
            0x3462898a2ae7b001L, 0x468bc3a10a34890cL, 0x84ff6ce56552b185L, 0xed95ff232c511188L,
            0x4869be47a8137c83L, 0x934606951e6fcd81L, 0x1ab5e8e453bde710L, 0x6386b61b30fa1157L,
            0x97f3a778e242d0cfL, 0xd870d281b293af3dL, 0xc3a5f903a836fafdL, 0x088bd6a24d49cd77L,
            0x4e38ddc2719162a5L, 0xf48286b4f22cad94L, 0x080f6f650c337557L, 0x05e6daf6aae1ad59L,
            0x7450f7229f336762L, 0xb75b43fb4c81784aL, 0xebd37a514f153148L, 0x0d4b3a39e0bc52c7L,
            0x562f36fae610a2e1L, 0x0e0e413e555bd736L, 0xd452549efe08402dL, 0xf2e2ff7be2c75e21L,
            0xf2385606c18aaf0dL, 0xdb609b507d8c6b8bL, 0x74ac5663c6c4f45bL, 0x0d84c9a356858060L,
            0x19d5b3643bc029b6L, 0x0dd8131e97ffc842L, 0xfa7303606bfffc05L, 0xf98c6d63ff48a16eL,
            0x34df46aa2d610767L, 0x83490ef054537f7eL, 0xe071f833e55ebfe6L, 0x0d4b94537ed4a6aaL,
            0x3cf85e4e333966fdL, 0xba15364649384016L, 0xc0e6bd623ca72405L, 0xdae6e879b8eab74aL,
            0xe4a41f17e70d3e0aL, 0x56e10c00dd580f70L, 0xa9a66bb41781d872L, 0x58e42dbdffe21573L,
            0x69450e1ce9674e6aL, 0x47fe345a350aa605L, 0xac958aa80455a5a4L, 0xbc1abca3fbeeb2f3L,
            0x08f760d9228900a4L, 0x9e1eb8a2dfec4387L, 0xe91bd1321f5fdc89L, 0xda11a24c514b9dc7L,
            0xb1f63d976e0e639bL, 0x41c11098f6123861L, 0x3d7736979f978f68L, 0x0820685b38c926beL,
            0x0e8c3dcab075b112L, 0x5e37299d89089ba4L, 0xa1f735eb8235b32fL, 0x2289d719e7b146eeL,
            0x1c9c9d0284d96719L, 0x5f8b358546775be8L, 0x317e34c009a07a39L, 0xb16b073eb0ee0a19L,
            0x423b36fd459f2a66L, 0x5f45053666f3f84fL, 0x63e7074f03c73d92L, 0x22080cf23288e895L,
            0xba4e71bf61dac16fL, 0x9643b3707db2cfb5L, 0x98e2db6c665e7178L, 0xcbc57de0ef3eabb6L,
            0x6239a2197582a8a8L, 0xf2ae968e55fda13dL, 0x36e7ac11d1f3a617L, 0x508f0acb609bd756L,
            0x6f42d435193a1ac2L, 0x2df2cab9d65e0b00L, 0x4584c1fde5f1ad55L, 0x602c500bdc8317c2L,
            0xc80d5b04f6337337L, 0x98abcf971892a773L, 0x5d33cf557e6c4475L, 0x05b5a78be74ccd40L,
            0x3ec2cce5290785f4L, 0x2eef1e9c4b36828bL, 0xdd274241a0ce8c55L, 0x3c4cb919b35c221cL,
            0xc1fd68d779db9923L, 0x7ff345b4eb7f3639L, 0x804d5881b2eefef3L, 0xa15f9c2826cb34dbL,
            0x64822b68adefa772L, 0x761e92f8d279850dL, 0xa5d049ab1061dba3L, 0x5f46fb02d10d2219L,
            0xc1cdaa5f9ca79b19L, 0xdd713a74701ebe60L, 0x6b626ec963951798L, 0x1d3ec8d78b96d16dL,
            0xdb885d52960e7f34L, 0xe39849cf3ea178f8L, 0xc1e37acdf807130bL, 0x3645880ebf333913L,
            0x3af81a7bec346c22L, 0x871c563e94324804L, 0xac55fb5e2817db4cL, 0x035b04c42565ebe2L,
            0x5094cafab11cbc3aL, 0x94d40a57481346b5L, 0x0f91a8492df723e3L, 0x126a70b84f779accL,
            0x4409e9a5d5c3f133L, 0xb1655339864151efL, 0x6564e506d11e9de1L, 0xd9a06f7b8860b488L,
            0x0d493e410b68b6c6L, 0x4e6fbf4b3b985a07L, 0x71c1b0ba9e52a2deL, 0x5775784ad3cb99d9L,
            0xbab84cec312107a6L, 0xd9066f5ccd59cf9eL, 0x8c656651dbb3ed84L, 0xa7448d0059484568L,
            0x2819237e5e8cb03aL, 0xd57eaf5239931b4bL, 0x6cd436fd5f7c1e73L, 0xf03b845f2a584931L,
            0x8847b9f1f2d55b7aL, 0xd49a38f8e59db8faL, 0xd5052cc47685dbfaL, 0x91e060fb399ecf2cL,
            0x5748fbea12dd2869L, 0xd0cee85adb889226L, 0xa35e9dfa5a64f56aL, 0x3118398bd0e3cbf0L,
            0x5e650b9a3cb34308L, 0xf575ccbebf49b91cL, 0xb3f8dd73257c80e2L, 0x13d7954e8294819bL,
            0x90b57ccd00f1591dL, 0xa8b13ef52ca7e284L, 0xe482d24e5b239833L, 0xb0648475f2b4d63fL,
            0x847e8fc889e2389bL, 0xa8b501ee1fc59ba6L, 0x29702f6acba4379eL, 0xfaba9600f3d2cd0fL,
            0x52ed7d9f45c6b578L, 0xa02b167546d6e2d0L, 0x9a41cb166618a390L, 0x83d464d7349d9f3aL,
            0x805485c9d2c70c6cL, 0x332f7ce3e077ecceL, 0x1ead372c068ebb04L, 0xd6866c5b3b5eb82cL,
            0x5b057c64bda94a33L, 0x11e1388f59653c66L, 0xffd2aca771c0abb8L, 0x2fabdd0e8e8ba606L,
            0xe974ffd57219e5e6L, 0x2b4e5c1e5f98e506L, 0xe7819b2cb44db4c0L, 0x6cbd78c408376520L,
            0x244285f39307f083L, 0xd152927f3a3af853L, 0x5b799885a8ba66e3L, 0x9300da64ea1a0644L,
            0x67399bf8688a0cabL, 0x047c301af4a94bb2L, 0x6750ecdf35c8471bL, 0x7598ae5c876d4080L,
            0x269e0cf307467534L, 0x2ef4d8dcaedbc549L, 0x2c6983c911c958afL, 0xb2fd7c07ae0bfa60L,
            0x3220a56d67450e80L, 0x7385883420eb9f69L, 0xdb1fd2951f15b047L, 0x0f08b35df55977bcL,
            0x42939b9f2e58127eL, 0x4d1d77e72414aa9aL, 0xfd8137f8b59bd084L, 0x167cc7f46a511504L,
            0x0263de0c6b50290dL, 0x2a1c2feb488ffab8L, 0x1194815038360d85L, 0x36374630d0ecb4e8L,
            0x609d38e22c59a974L, 0xee23867f7c9b5f54L, 0x40e53a7804b0ef15L, 0x8f287f1a3be6e458L,
            0xba7334b0f0af9e75L, 0x09f003e8e0e9c6c0L, 0xc02dd0d35c42bc56L, 0x63dca83acd6be04aL,
            0x9617b58a79fdd826L, 0x563d25e6f891bb33L, 0xe3c3d3f3f6d58588L, 0x359977baa315b1b4L,
            0x0df431301d9e6bc5L, 0x4074bb10d0003ca5L, 0xf440159140f2b453L, 0x3a6cc6e14820f5e2L,
            0x4b352bdacf3a37c4L, 0x9ef3b8df89ea4c29L, 0x8a1b2495a1414892L, 0x670b7f423f78b7c9L,
            0x7513c7ccf6ee3c3aL, 0x9ba96cb53c24408bL, 0x3316c3dc4ec859f0L, 0x501337e1a7f1e218L,
            0x9a1544a6029c1eb5L, 0x9b43b15859c3e96fL, 0x058011e22698bd4bL, 0x589b8eaea60d54a4L,
            0x68ccb8c6cd7ec24dL, 0xe55beb5896455705L, 0xba6069cf90a8f1e2L, 0x896a18c3eb90a6d6L,
            0x870d3d80ae0b9323L, 0x48688d8b457f501bL, 0x8f1a8c1b84b3ba62L, 0xd1b7b64dc136f6b3L,
            0x3c6a7025428547e9L, 0x199bcc50a190fb6fL, 0xa5de0eed4bda0979L, 0x31041667821cddb5L,
            0xe9df34e2678fb4e3L, 0xdd7222eaee54e524L, 0xaae6488b26c7af56L, 0xe8a560dbbd2eb6b3L,
            0xe37c99a7f5defceaL, 0x1572be8d78f3afacL, 0xf69ffb64131633aeL, 0xa837ae34963616fbL,
            0xaf0a9f03d137c170L, 0x0d3e02b464018a48L, 0x11753aea03bb0ecdL, 0x32d9cca610dceb34L,
            0x2622bb6a6e7a11e3L, 0xdc99a44c515ec8b3L, 0xd7d720ad0a770b28L, 0xe322f742d6d051c2L,
            0x745f2b6e3ea9cd2bL, 0x951f21478e6b9662L, 0x227f21d8c0713385L, 0x0cb729235e6876eeL,
            0xd323b857d9721a53L, 0xb2f5f599eb743346L, 0x0efb30babe65a283L, 0x94c1190da321d470L,
            0x117c63209fba9efeL, 0x738cf92baa4bc2cdL, 0xc3bdd29b33277165L, 0xd78a2fab38f6dc46L,
            0x35c44aafdefb91e2L, 0x321e26bf321fb60bL, 0x12db436288b37172L, 0x158a2d49e51c261aL,
            0xc9202ac8ba71c873L, 0xd02fa93dc97cc7b7L, 0x1f8bd11b747e901eL, 0xf7a17b2f74aa321cL,
            0x284d02d7552a3e90L, 0xeb86a8251533c574L, 0xb3fd774eaf4e77f8L, 0x31df2951c3ff37b1L,
            0x86e38546195a69e7L, 0x6737aaf165a1389aL, 0x2e2e925079feee0fL, 0xf7bd5a988596c1bbL,
            0xccf835db6a10d2dfL, 0x6f42700f37c94701L, 0xa6e86f7ba2779a5cL, 0x0a43a4f7036d1ec2L,
            0xd798bd6d52ad26daL, 0x218f6912af38b818L, 0xd48684f266f2e186L, 0x8f675048b7b012e5L,
            0xe5e469aac68eaf1dL, 0xe2740035697de79eL, 0xc22d6bd6d08baf1dL, 0x341774636bdc8f41L,
            0x7dfc6b73f7ba322bL, 0x7566343607bb525bL, 0xae94d116ccf1e74bL, 0x6ca1b59934cc2697L,
            0x4c2fb1c45b749cedL, 0x989999bbdd2ec893L, 0xcc4e27afa81bc8a8L, 0x6ddadf15ebf85830L,
            0x38fa9cb2ce72bc16L, 0xacdaffe39db4bbdaL, 0xbcc4682ebd095d93L, 0x483f539d354559adL,
            0x45de92e997e2915cL, 0x7ec5c881c5344a55L, 0x9d1844fffa091545L, 0xcd9b08d4dcda27baL,
            0x1f7495a5f36c34ceL, 0x4f0fc9647d99afd7L, 0x5ac375ec59321cf2L, 0x5c07ce6df7e1d9a2L,
            0x49f211880d688b4cL, 0xf85fdd8ccad0867aL, 0x7d510164d8f197a8L, 0xc64108c5732cfa0eL,
            0xb262d660d3a2c648L, 0xd5d5614571dd2efaL, 0x0ec1a6d0dd5d5391L, 0xbf07d939d2535f02L,
            0x035bce3021e51045L, 0x423ae115ec99d154L, 0x22ea1d3abd893838L, 0x517fc1107eaa6a83L,
            0xc5967cdf353aeac6L, 0x096ae2c3dff65ce6L, 0xab1b908b97dc911bL, 0xf3d84c286f22611cL,
            0x256823815030d8a2L, 0x3bd9b119887342e4L, 0x59926f3401f437d4L, 0x74edf41038d3986fL,
            0xe2b35bf615038253L, 0x4d09740a6b44db89L, 0xa37edaf089c0eeabL, 0x8263ba2c23e2d62dL,
            0x8784aff57d390c3cL, 0xfb49ab0635d66c3aL, 0xdeba73c2562bff1cL, 0xe2e6bf8cb6e29717L,
            0x0e70431c63d86e46L, 0x20d717e16aae6010L, 0x031af57cdcf2cd36L, 0xd55fbeef1c5357feL,
            0xd361d871f4e393feL, 0xb3416e718d32d214L, 0x7b351f93f909fc00L, 0x16916de7b96a26bdL,
            0x4fec1248b5dedb65L, 0xfae1aa9a62bfa096L, 0x92e7910a6b0084a9L, 0xd12bba8672e8aaa9L,
            0x316558d69efc8f6bL, 0xb0dde29eb96fee87L, 0x2125a2be5bf67eb3L, 0x5905903f46531fe4L,
            0x2a9927e8175ff60fL, 0x794376f2bb5d6d96L, 0xfa9f65d2b4848b12L, 0x2b92665a263a5091L,
            0xabcaccfab8464c65L, 0x05b2fb2a46d1a0bdL, 0xa879920d28c0d54cL, 0x50394088a8ea4953L,
            0x61b0c87f0084129dL, 0x29ebcd1078d6e2b0L, 0x2440c652f6bacf89L, 0xbd74d596cf4c8eb1L,
            0xe4b009e5c334766bL, 0x07db26843cf72cb8L, 0x4171d5edd5468876L, 0x608d5c2c348c143cL,
            0xa19e0a2b81da6eb5L, 0xb65a7be9354c1390L, 0xf4f4c437cb9bb324L, 0xfc24806650c823bdL,
            0x4c2331521e7f2966L, 0x54f66e42eb73bafeL, 0xf06c11f3d2fe29aeL, 0x8ba8d0f28cbb0fcbL,
            0xf3617850d1ae7976L, 0x96463b47cd9a7286L, 0x8edc2133b35c3779L, 0xae43f70f181d9371L,
            0xe7628d75c9a3c2e7L, 0x978499ba4193b333L, 0x99bb4bf79b0a46c1L, 0x4c52676d7e4d0a58L,
            0x2064ee3910693deeL, 0xfc43514d16633997L, 0x1bc1741ce05c4cceL, 0x6e9588d40f3396f6L,
            0x146fe816bb3a3708L, 0x2b3db8ee05eefa87L, 0x6ec21a91189ec0c0L, 0xa8a907b34108faf1L,
            0x708b80912235684fL, 0x2bc8ba70edfe680cL, 0x4d118826481266efL, 0x8f93a3a5de887175L,
            0x3308e9133a950fe3L, 0x939ed8b0d7e91f87L, 0x666beee64002b6b0L, 0xc8f129ec69ce7811L,
            0xd57593c68ce93ea0L, 0x02d6a3e66edcc862L, 0xbe1d00d16a2271a6L, 0x34fbeaf95e0c673fL,
            0x9845ab59483a0e86L, 0x257d47d5abf88962L, 0x28af39f39319545bL, 0xe3fce03abd8171eeL,
            0xa4c5f606dccc96f1L, 0x4d414846267c4962L, 0x6ccf77f81d9dbf70L, 0x947bf43c729a71ecL,
            0xfd656c39c4fa824cL, 0x8f652cf2d1e04fd6L, 0x8cb11929a65b6aeeL, 0x094948f16a8064daL,
            0x7434e703a4d03d5fL, 0x9361d3f63af4aa35L, 0xa998c1eeec3fb422L, 0x51eb94754b5992a2L,
            0x6e109c0347ef6979L, 0xe3c9738d67c582e2L, 0x9c735e3857ec57bfL, 0xbe6415659e12c64bL,
            0x73924584e31b9099L, 0x8f676821e60b0945L, 0x5614e3a695d5289dL, 0x7ecd448787517ebaL,
            0xc96db02038dbaf5bL, 0x069299ed774fa6c8L, 0x0b4ace5a8ea16ac8L, 0xbf2f4f23a6c92295L,
            0x90bdc4f1e931656cL, 0x7cd5b0b95ac34d3aL, 0x2032bc59d3dc1710L, 0x702c1a0cd5609379L,
            0x609d33abc01ff3feL, 0x8ae5d8f283b2748bL, 0x2cf3778fa7eaae1dL, 0xe8a0d7b1919df9e3L,
            0xe487894f6d602a0bL, 0x929858549609626aL, 0x46e540cd86bf46e7L, 0xd1daf4382128d9eaL,
            0xc47239c06b22ef75L, 0x8b7aad8ffea1b991L, 0xd6c1d2e315273fa0L, 0x2fda11cd74177e6bL,
            0x333cb0a145919fd7L, 0x5970b31a49f37b16L, 0x7890bc68793bb959L, 0x2a060f45a1719347L,
            0xeb298f0264bf379dL, 0xd7c4fd7921707400L, 0x374635e7713ed165L, 0xc60c008df0296d05L,
            0xbf13739a8d3c7dbbL, 0xbfb945ef1cf94d1dL, 0x75fe953c3a3a8315L, 0x09f83064f4150c02L,
            0x6784a3b452055343L, 0x73ed26d185738f51L, 0x6c59094e8c998390L, 0xeade93e19d60d4b5L,
            0x8cf7cc8e62bc869dL, 0x22f85626f7f69298L, 0x6679c449ac22edc0L, 0x7017d0003e897435L,
            0x308fc450a6c62bf8L, 0x2578b45bc6f34cabL, 0xcbb936c9d253db39L, 0xc4e70e5bbc5e002cL,
            0x29db6985be6c9459L, 0x96afe876f5f6250cL, 0x829f766f138f95e6L, 0x4369632017c8fa0dL,
            0x0da90c817ca890a2L, 0x38d160dd675e2376L, 0x20df15ad986408eaL, 0xd192623c3d9b3f41L,
            0xd846f79123baf4aaL, 0x6cb058a0edfbf056L, 0x1b192f0be8dc77a7L, 0x3a11b3dfcc81a441L,
            0xe914410093ad7767L, 0x3126257e578bdf60L, 0xd5d5e470410cb6eaL, 0x4e1bf5d4209248aeL,
            0xe1e4c2924f35192eL, 0xac9944825cb7ef5eL, 0x8d2cbe6996eb3475L, 0x1bc05d2a079592d7L,
            0x564a9f06755e71f3L, 0x9bb767d68e9f2537L, 0xe4b045acf13978a2L, 0x4b7519cb9028ac83L,
            0x9df655284198b85cL, 0xdc32ab4d421a2b61L, 0x4c5d7f5323c1960cL, 0xe4273ff318f5c7b3L,
            0xd73ef5ea88a3e99eL, 0xda2ffb6a863c850bL, 0x9555a4144e05ad82L, 0x950104dc15092ebfL,
            0x39d121a61f19dbfeL, 0xc6804e29d60d7814L, 0x7e98bec5ba17d58bL, 0x8b2c6b0e6c3b749aL,
            0x0301a07c84aaccdbL, 0x93dee719932225a3L, 0x381611a50bac0ae1L, 0x572a8816f6e407b4L,
            0x0420efe85aa75232L, 0xc1f53f78b9ffcf4dL, 0xbeda53bc95b96ec3L, 0x9f357114059c8eabL,
            0xe38239260b584150L, 0xccbca17f4eed2ad0L, 0x1528080b61f54198L, 0x5b8cdc4c40d49f30L,
            0x1617db48eb6640d0L, 0x6fed27f88a516c99L, 0x37056e05b4724179L, 0xec7bc122da9538d8L,
            0x9fbfe01ca2c0fd57L, 0x2fc96b31dccafd9fL, 0xe26a72009daa1249L, 0xe9fb2e3998d16a25L,
            0x4a87dc39d24133aeL, 0xd5340e98fde806deL, 0x272b62b5dd0d7fe3L, 0xca4625581bf9dbe1L,
            0x8677af77de374a90L, 0x27dbec9e28f857edL, 0xb4aefc44d036612aL, 0xcf2e8ebdb0f6bb11L,
            0x76023506c94e0532L, 0x864e72d4488c7a7aL, 0x0b81058fdac18fd3L, 0xdf93ee5b6674a0f4L,
            0xdb30565511789d77L, 0xcf5fe22dc0375f30L, 0xa6e62e6e4edb4043L, 0xbce383957a728669L,
            0xfe4dd4e9633db2c6L, 0x24e68818b2a6d6cdL, 0x048a89c5424b4cdbL, 0x7fc7bc75bbbe5768L,
            0x79596343191e0ff2L, 0x5510b9cd8306839fL, 0xff2668b4eae7bb53L, 0xb4c03e6363c9e244L,
            0xc9e3c0c1c015eb6fL, 0x52531f5f898a744fL, 0x0484005b2a805083L, 0x31673b70c6f23c53L,
            0x5bffe158f323a7c2L, 0xc742bc0d0c55f125L, 0xd95c32fe7e18379dL, 0xc1f2f613ee3c2e21L,
            0x3217a43ff0daaa0eL, 0x3a9fa27258257e53L, 0x80b42af5a393bcf2L, 0xb6967fd6a302f65eL,
            0xfdc07bc592dbb125L, 0xcb83b8b9f64c3c3bL, 0x9cb572b041015355L, 0xc12dc512aedc530cL,
            0xc8db824276c083ceL, 0x86923b0e2903627fL, 0x1385cf2be22827cdL, 0x21b7616ced869ef1L,
            0xc74d497d079901e6L, 0x9e03c843bb13f658L, 0x915b89077a81ec7fL, 0x288a10b00768d244L,
            0xd88eb6745a557569L, 0xb3c98071a3d13b20L, 0x8f23aff44d352f03L, 0x2bf39ca10e45bdbbL,
            0x0f1bea47e2c68a4cL, 0xf8d5ab01c1ad6b55L, 0x679e0601953d1e31L, 0xd793f3aacb3c520fL,
            0x96fc350ccdb76eabL, 0x9fa0178362df447bL, 0xc11c63febf83598aL, 0x3aa88df3a1a71323L,
            0xab2f8338a09ca82aL, 0x32a2133050a71357L, 0xffecf97ca3ff65e1L, 0xfb6fd13318f5cb79L,
            0x3acf76875acad366L, 0xc577ffff529f74cfL, 0x368a90182031dd12L, 0xafbf2311ad656d52L,
            0x80cd4f9f23fcafddL, 0x451717a061972d1fL, 0x0bbcbdae779cfbf3L, 0x133ca541293fd40dL,
            0x6f241a21fc40b108L, 0x9adecbcf0c28110bL, 0xfab528d93bac6d3aL, 0xf4ea3d459b0654aaL,
            0x7e2e9ef35a5aafbaL, 0x28730469eded0fc7L, 0x3cbae97a12632fbeL, 0xded6960c0be007a8L,
            0x2a11758a7c52c43eL, 0x289de4875bda262dL, 0x6e13eea58caf3fa7L, 0x020c8ed0d5d673c1L,
            0xdb4b3e7719d523b6L, 0x49143c819d111fc3L, 0xe07479f9ddf45d8eL, 0x68f4654bcc07435bL,
            0x513bd537af510064L, 0xcf956c3a3933ba38L, 0x97e1eaa33f88eeccL, 0x18be860a2504a1c5L,
            0x84408412fc0bf397L, 0x0b6bdba7e154bdf7L, 0x1d8f8b446b544be6L, 0x6f06b3dcdef17a03L,
            0x30c6e14df59f8cefL, 0x01c97ba9910219cfL, 0x33ddcc087d1aeb5cL, 0xe31b94300cfbcbcfL,
            0x0adeb8a98786bb28L, 0x3f69d5b0e3ec8f17L, 0x99f5a15f635296a6L, 0xce9fac7526862e86L,
            0x3a88964201bd7524L, 0xec94d643ea71be51L, 0xc4257084d97ab1c5L, 0xf369b10a73b4d382L,
            0xac02bb473dbc5fd1L, 0x4fe73a86d95d7222L, 0x858806616fe3d553L, 0x10680debcb0693e4L,
            0xcaa9aac77c954093L, 0xf29c7530415d71e5L, 0xc32b319e09de9e48L, 0x1c67107ed497ebc4L,
            0x731da71593324021L, 0x49774770588c055aL, 0xf978dfdc28084220L, 0x058b3f2780b5a7ecL,
            0xe4ebf2ca21410715L, 0xd3841ed97708421fL, 0x0dbc9401dc51eb4eL, 0xf47a96de499aa2e1L,
            0x224da94d8542ba0cL, 0xa3426a80b4dd0a4aL, 0x857caef48ef7e5b6L, 0x11356ad6ede44bf5L,
            0x1a32471bd26acd7aL, 0x199396e31de7b358L, 0xb7ca7950dbbb4a92L, 0x6ab23720409790a7L,
            0x2abfdb93a3159d10L, 0x23913b403946c4a7L, 0xac7c9f339a822344L, 0x12cffe9625cbe744L,
            0x89558b98548b1946L, 0x77be65945c191139L, 0x3ba8d1fc701f4347L, 0xb143664560327f20L,
            0x48baccc3ef2081ffL, 0x450c379d24beb8e9L, 0x1990b609485db827L, 0x6c6a565d7129ccb4L,
            0xf9724a82872bd619L, 0xcfe629aa56717e20L, 0xfde48d87e844ec93L, 0xb32f79e5dc9ce4c1L,
            0x7c9d88364238519fL, 0xe943aceba65150f9L, 0x5301e8550cbdd076L, 0xabb8392364453b3cL,
            0xdfb4b4a3cf84aa2dL, 0x269e45f7a6b48a42L, 0xd6783043ab383fcfL, 0xe4ec475d296a69e5L,
            0xe2e273ef65555361L, 0x6bd3084210a75af7L, 0xf2ebc493b909d8c7L, 0x4d20f3d435e9bc94L,
            0xa465e41c3c36d433L, 0xc1b259456f4341c0L, 0x260093703d6cf2ebL, 0xda68d9dea0aa9bdaL,
            0x5662a12a210b2a47L, 0x54675bd1a1b4b467L, 0x9dbd416302ec2468L, 0x3c7130a5032d823aL,
            0xabfdef2d9a4fd92fL, 0xd4034e276021451fL, 0x13834d3d0e43ab73L, 0xdc181442b438b2d6L,
            0x1736ffb392c25e23L, 0x289b94003a946252L, 0x99705629b221ca37L, 0xa7b22a5bb26775d6L,
            0x2dc12f9f04435661L, 0xaadd48b556bc9e7cL, 0xf6992e8e94b68a49L, 0xd50420466c9456e3L,
            0x0ea8305ecdfb1266L, 0xfe0b1d7e4f0ef297L, 0x563de834c4e56a46L, 0xc62b8099b5b264c6L,
            0xf6e76aeaf533c784L, 0x0d4680470b790968L, 0x288a50754707431eL, 0x8ad167ed38df547eL,
            0x9052fed81a8ca4faL, 0x5975ac56f0548ef1L, 0x588bf7d0130111aeL, 0x9ec02036a6688a24L,
            0x8c9a454af9e09984L, 0x333ee6727bd12dcbL, 0x9847468f925dc38cL, 0x446ed5203696abacL,
            0x71fddf9ef5b5def6L, 0xd4d61614cc333541L, 0xd08a0694cd7f72a7L, 0x686cfe3ea1889281L,
            0xf039404e0dd3333fL, 0x052c620eb18b4246L, 0x4e4de47f86d84713L, 0xfe0450396b209851L,
            0x99d6e893b01ed92bL, 0xd94cf8705f8eba86L, 0x763451110c00291bL, 0xdf4f60b9aa45d064L,
            0xf473d4bfd86ad526L, 0x41b9e3fa1a6dba94L, 0xbaa7cdeb00796a4aL, 0xf668194c40626450L,
            0xb894e0ae40a9c87fL, 0x5bc1eea8587d3ddbL, 0xc4c0ecb91bb50d75L, 0x819fdfd17ff2917bL,
            0x681484e54b6b12f7L, 0x2f510aa2f8977995L, 0x7d1582a293b8fa3dL, 0x3dad5a0f0da45470L,
            0x33c113aefb480520L, 0xbd524b2da7ce6c1fL, 0xe4cc051d00d8ddc0L, 0x2995950e206efa90L,
            0x8b0e5dca588e3f50L, 0xaabb3583f7f87082L, 0x75dbbecfa34cb4d6L, 0xf195977068849ae8L,
            0x9223ca6fbb72767cL, 0xda7211029d59f04eL, 0x18d9987c6566405cL, 0x57833aa39ef75a04L,
            0xd1750e36481f654bL, 0x0ce2b66bc8796acbL, 0xc7e79aa76c96b057L, 0x68f95b6b3c5cdc1dL,
            0x2f5725cf5fc583aeL, 0x6b973013fd4484a6L, 0xaaeb2687f2d8bb96L, 0xad29cce061ba3934L,
            0xcb60dd1c437eb1d9L, 0x5cd6f46b78181bb4L, 0x1561cdc95ace24d9L, 0xbb774e6705806245L,
            0xdc29c8df29b2e975L, 0x6ee5ba502839dccdL, 0x670869bb64c60f69L, 0x008ca2931e927ae7L,
            0x35cf6c0a27d8de77L, 0x94a3d86209af3920L, 0x4095a276475df5b7L, 0x1119e4c257ccf7fbL,
            0x33376166d9064fe8L, 0xd68c2399f968b905L, 0xb7bf2902f40fc101L, 0x4ec18604cfd551e0L,
            0xeb8e7fe1b6678e99L, 0xdcfe68fc0e042fa6L, 0xd2e58dfb1a8e3866L, 0xf4322bc57fb9a35aL,
            0xe0c665c8cf1fb49bL, 0x60de1f1050684297L, 0xf400c04cb00784cdL, 0xfc2a216f12016984L,
            0xa808b477fd65fb4aL, 0xd9b614adfcb5d0f1L, 0x50afdbc66e3efad2L, 0x82337b3f1764851cL,
            0xdc98850eb93ef45eL, 0xe1c314bbc2c6af27L, 0xd35614ba27e74a71L, 0xa5d592e04a31bb6fL,
            0x3f143cd0bc243fbeL, 0x081641ac25408b21L, 0xd4166b32a26fc1c6L, 0xccd088ee4d4a1f67L,
            0x698c913d46c1ec99L, 0x0f6b9086a5b986abL, 0x4a73c05ef72e3595L, 0x0307aeeb350ab081L,
            0x43e20045bcb06b0eL, 0x3f58d1d6cd3aa0dcL, 0xd71cd7c996faba80L, 0x4431d8268eebfb71L,
            0x254246df109e3dd5L, 0xa7ca1449a238b06aL, 0x49b40e7b082493e7L, 0x45d80e6bd330d613L,
            0xaf3d8a578b6d6232L, 0xa4b98341785262d1L, 0xf4f1f424af963102L, 0xa84a986395146774L,
            0x90da037fb61d5c88L, 0xb645534b2cf5b89fL, 0x3fdb3073310934b4L, 0x1a0307d01f57f514L,
            0x509c9b87a4a1e66cL, 0xbf320cf0888d8aa8L, 0x45a51f76c5f76892L, 0x23eb7a2b99a64402L,
            0x4c600e5675dd7757L, 0x4896757aa01a5c34L, 0xb808dbbda7a8a1daL, 0x762c21058ba50349L,
            0x99b0a9d5deeebb37L, 0xd6d98ef70a1e465dL, 0xb052f2c1163894f6L, 0xc55e73526f8bc8faL,
            0xb31a0537f5b3b269L, 0xf09c1819c0c7f78aL, 0xc36d4e2187e430f8L, 0xf141831a47299c7bL,
            0x62f938047903ef34L, 0xf2a0dd678f92e0a5L, 0x0c7fe6a53efaaa65L, 0xcc539fcdcc466310L,
            0x55199357cdc55491L, 0x6917fb45babb399eL, 0xb098da3c7b012b1aL, 0x054916438f426c41L,
            0x1a5ff3356d77d43bL, 0x74e71995e0aacf1aL, 0x6562a8da6b5e69eeL, 0xacbc2b8d1fb16ea8L,
            0x400ea8e1f3f5535eL, 0x2ea792dad3a4538fL, 0xf580fe481db60b5cL, 0xcb101198dd0aba9fL,
            0x259acbe0461cb837L, 0x30033c3964b56a40L, 0x6c15d4283eeb6fa6L, 0xdea7b626998ea3eeL,
            0xdbb2e1b8c0c2abdbL, 0x3a856a6742b6edc2L, 0x0777ed6b1683f48bL, 0xde72fd7d6db3bb63L,
            0xc8766969b599dc68L, 0xb39a5b76dce26160L, 0x97464948ce81d8a2L, 0xae20fda5af404ae6L,
            0xde1100c4f1ae3265L, 0x05a94d43bf60f574L, 0xc087a2116f52d0fcL, 0xfacb3be87e615d89L,
            0x0e184cb9fba7b0feL, 0x824779bede6d84ffL, 0xa0852e96875da152L, 0x620046e8ba89baefL,
            0x247c32c5f34b08ddL, 0x49294468356e7298L, 0xaf6d6e0f8b5009ebL, 0x8c25bfcdb8abd77fL,
            0x4f5464a1bc417e38L, 0x2df8fbe8993f8c9fL, 0x6540566281dd6d91L, 0x0b90690dcfb03a83L,
            0xe270b7c7f8fab463L, 0x898ead41792a7f87L, 0xa1b1248822b7c292L, 0xfa2c0d61dd383eabL,
            0x5574c091830bd677L, 0x43640e20702986e5L, 0x622d0a1c860d0302L, 0x9528ea0051990eb9L,
            0x28f057ef30af388fL, 0x88320e974a2721a0L, 0x8a12cb33cdd88b60L, 0xd91a9763f991780dL,
            0xdf22e332867c0e97L, 0xad95801b6c801f10L, 0xb34e21d4afe2c4a0L, 0xd5465bf172494dd3L,
            0x16594af34f1b5767L, 0xa675dceaee1591e6L, 0x53db891db5e1d768L, 0x39a80f5d365c71afL,
            0xdce01c73eac54372L, 0x1087fb03e5ce69e9L, 0x067cac3905594378L, 0x275d24c9aa1607f0L,
            0x9163a77a53e361b8L, 0x17d10f8254fa7f0bL, 0x49efeab6642e9e45L, 0x376e24839b1df1beL,
            0x0c46221cc408546fL, 0x98eb5bb7001ebf5cL, 0xc6c4d56e3c9a78efL, 0x023c0723e123a899L,
            0x145912ec44b57548L, 0x488a34fe824ff4c3L, 0xac3bc6de9929c707L, 0x1dbac6e98813a70fL,
            0xf566054941858266L, 0x18e0a3a2a8b8f2f1L, 0xcc6245a26564a399L, 0x14416ca0e1a84a9aL,
            0x4eaf095631a6e7bfL, 0xf2f89f104c9d0b8dL, 0x8fb278a5953e52d8L, 0x8fcee83a30a8be30L,
            0xb66850da1a0ceb33L, 0x5f37d31bad76f4dcL, 0xff4d956ffea8dea4L, 0x078c583b396635b3L,
            0xad268fb5b1105028L, 0xa480149a0dcbc5f4L, 0xb0e8d69c8b15c864L, 0x6ed49c46f19bb8eaL,
            0x7f1871fdf321818dL, 0x1ec5816f5a9843eaL, 0x77c8da91b5313675L, 0x4cdb66ad515e0717L,
            0x2ec4712b0bfdfcd6L, 0x6c6f5767fff27330L, 0x071083b972d80c0cL, 0x8d8325e82c4fdcdcL,
            0xb47a658dad8e13a4L, 0x88710bf005fda027L, 0x69bd3edaf7111200L, 0x0dccdd0c65c810ffL,
        };

        RandomAssert.assertEquals(expectedSequence, rng);
    }

    @Test
    void testConstructorWithEmptySeed() {
        // An empty seed is allowed
        final MersenneTwister64 rng = new MersenneTwister64(new long[0]);
        // It should be functional so check it returns different values.
        Assertions.assertNotEquals(rng.nextLong(), rng.nextLong(),
            "Empty seed creates sequence with same values");
    }
}
