/*
 *  Copyright (C) 2012 Carl Green
 * 
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 * 
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 * 
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package info.carlwithak.mpxg2.model.parameters;

/**
 * Contains a reverb spred index whose value is based on size and link status.
 *
 * @author Carl Green
 */
public class ReverbSpredValue extends GenericValue<Integer> {

    /**
     * Arrays of spred display values for each size.
     *
     * TODO fill in missing values.
     */
    private static final int[][] REVERB_SPRED = {
        {
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2,
            2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4,
            4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6,
            6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 9, 9,
            9, 9, 9, 9, 9, 9, 9, 9, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 11,
            11, 11, 11, 11, 11, 11, 11, 11, 11, 12, 12, 12, 12, 12, 12, 12, 12,
            12, 12, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 14, 14, 14, 14, 14,
            14, 14, 14, 14, 14, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 16, 16,
            16, 16, 16, 16, 16, 16, 16, 16, 17, 17, 17, 17, 17, 17, 17, 17, 17,
            17, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 19, 19, 19, 19, 19, 19,
            19, 19, 19, 19, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 21, 21, 21,
            21, 21, 21, 21, 21, 21, 21, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22,
            23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 24, 24, 24, 24, 24, 24, 24,
            24, 24, 24, 25, 25, 25, 25, 25, 25
        },
        {},
        {},
        {},
        {},
        {},
        {},
        {},
        {},
        {},
        {},
        {},
        {},
        {},
        {},
        {},
        {},
        {},
        {},
        {},
        {},
        {},
        {},
        {},
        {},
        {
            0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5,
            5, 6, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 8, 9, 9, 9, 9, 10, 10, 10, 11,
            11, 11, 11, 12, 12, 12, 12, 13, 13, 13, 13, 14, 14, 14, 14, 15, 15,
            15, 15, 16, 16, 16, 16, 17, 17, 17, 17, 18, 18, 18, 18, 19, 19, 19,
            19, 20, 20, 20, 21, 21, 21, 21, 22, 22, 22, 22, 23, 23, 23, 23, 24,
            24, 24, 24, 25, 25, 25, 25, 26, 26, 26, 26, 27, 27, 27, 27, 28, 28,
            28, 28, 29, 29, 29, 29, 30, 30, 30, 31, 31, 31, 31, 32, 32, 32, 32,
            33, 33, 33, 33, 34, 34, 34, 34, 35, 35, 35, 35, 36, 36, 36, 36, 37,
            37, 37, 37, 38, 38, 38, 38, 39, 39, 39, 39, 40, 40, 40, 41, 41, 41,
            41, 42, 42, 42, 42, 43, 43, 43, 43, 44, 44, 44, 44, 45, 45, 45, 45,
            46, 46, 46, 46, 47, 47, 47, 47, 48, 48, 48, 48, 49, 49, 49, 49, 50,
            50, 50, 50, 51, 51, 51, 52, 52, 52, 52, 53, 53, 53, 53, 54, 54, 54,
            54, 55, 55, 55, 55, 56, 56, 56, 56, 57, 57, 57, 57, 58, 58, 58, 58,
            59, 59, 59, 59, 60, 60, 60, 60, 61, 61, 61, 62, 62, 62, 62, 63, 63,
            63, 63, 64, 64, 64, 64, 65, 65},
        {},
        {},
        {},
        {},
        {},
        {},
        {
            0, 0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6,
            6, 7, 7, 7, 8, 8, 8, 9, 9, 9, 9, 10, 10, 10, 11, 11, 11, 12, 12, 12,
            12, 13, 13, 13, 14, 14, 14, 15, 15, 15, 15, 16, 16, 16, 17, 17, 17,
            18, 18, 18, 18, 19, 19, 19, 20, 20, 20, 21, 21, 21, 21, 22, 22, 22,
            23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 26, 26, 26, 27, 27, 27, 27,
            28, 28, 28, 29, 29, 29, 30, 30, 30, 30, 31, 31, 31, 32, 32, 32, 33,
            33, 33, 33, 34, 34, 34, 35, 35, 35, 36, 36, 36, 36, 37, 37, 37, 38,
            38, 38, 39, 39, 39, 39, 40, 40, 40, 41, 41, 41, 42, 42, 42, 42, 43,
            43, 43, 44, 44, 44, 45, 45, 45, 45, 46, 46, 46, 47, 47, 47, 48, 48,
            48, 48, 49, 49, 49, 50, 50, 50, 51, 51, 51, 51, 52, 52, 52, 53, 53,
            53, 54, 54, 54, 54, 55, 55, 55, 56, 56, 56, 57, 57, 57, 57, 58, 58,
            58, 59, 59, 59, 60, 60, 60, 60, 61, 61, 61, 62, 62, 62, 63, 63, 63,
            63, 64, 64, 64, 65, 65, 65, 66, 66, 66, 66, 67, 67, 67, 68, 68, 68,
            69, 69, 69, 69, 70, 70, 70, 71, 71, 71, 72, 72, 72, 72, 73, 73, 73,
            74, 74, 74, 75, 75, 75, 75, 76, 76
        },
        {},
        {
            0, 0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 5, 6, 6, 6,
            7, 7, 7, 8, 8, 8, 9, 9, 9, 10, 10, 10, 10, 11, 11, 11, 12, 12, 12,
            13, 13, 13, 14, 14, 14, 15, 15, 15, 15, 16, 16, 16, 17, 17, 17, 18,
            18, 18, 19, 19, 19, 20, 20, 20, 20, 21, 21, 21, 22, 22, 22, 23, 23,
            23, 24, 24, 24, 25, 25, 25, 25, 26, 26, 26, 27, 27, 27, 28, 28, 28,
            29, 29, 29, 30, 30, 30, 30, 31, 31, 31, 32, 32, 32, 33, 33, 33, 34,
            34, 34, 35, 35, 35, 35, 36, 36, 36, 37, 37, 37, 38, 38, 38, 39, 39,
            39, 40, 40, 40, 40, 41, 41, 41, 42, 42, 42, 43, 43, 43, 44, 44, 44,
            45, 45, 45, 45, 46, 46, 46, 47, 47, 47, 48, 48, 48, 49, 49, 49, 50,
            50, 50, 50, 51, 51, 51, 52, 52, 52, 53, 53, 53, 54, 54, 54, 55, 55,
            55, 55, 56, 56, 56, 57, 57, 57, 58, 58, 58, 59, 59, 59, 60, 60, 60,
            60, 61, 61, 61, 62, 62, 62, 63, 63, 63, 64, 64, 64, 65, 65, 65, 65,
            66, 66, 66, 67, 67, 67, 68, 68, 68, 69, 69, 69, 70, 70, 70, 70, 71,
            71, 71, 72, 72, 72, 73, 73, 73, 74, 74, 74, 75, 75, 75, 75, 76, 76,
            76, 77, 77, 77, 78, 78, 78, 79, 79, 79
        },
        {},
        {},
        {
            0, 0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7,
            7, 7, 8, 8, 8, 9, 9, 9, 10, 10, 10, 11, 11, 11, 12, 12, 12, 13, 13,
            13, 14, 14, 14, 15, 15, 15, 16, 16, 16, 17, 17, 17, 18, 18, 18, 19,
            19, 19, 20, 20, 20, 21, 21, 21, 22, 22, 22, 23, 23, 23, 24, 24, 24,
            25, 25, 25, 26, 26, 26, 27, 27, 27, 28, 28, 28, 29, 29, 29, 30, 30,
            30, 31, 31, 31, 32, 32, 32, 33, 33, 33, 34, 34, 34, 35, 35, 35, 36,
            36, 36, 37, 37, 37, 38, 38, 38, 39, 39, 39, 40, 40, 40, 41, 41, 41,
            42, 42, 42, 43, 43, 43, 44, 44, 44, 45, 45, 45, 46, 46, 46, 47, 47,
            47, 48, 48, 48, 49, 49, 49, 50, 50, 50, 51, 51, 51, 52, 52, 52, 53,
            53, 53, 53, 54, 54, 54, 55, 55, 55, 56, 56, 56, 57, 57, 57, 58, 58,
            58, 59, 59, 59, 60, 60, 60, 61, 61, 61, 62, 62, 62, 63, 63, 63, 64,
            64, 64, 65, 65, 65, 66, 66, 66, 67, 67, 67, 68, 68, 68, 69, 69, 69,
            70, 70, 70, 71, 71, 71, 72, 72, 72, 73, 73, 73, 74, 74, 74, 75, 75,
            75, 76, 76, 76, 77, 77, 77, 78, 78, 78, 79, 79, 79, 80, 80, 80, 81,
            81, 81, 82, 82, 82, 83, 83, 83, 84, 84
        },
        {},
        {},
        {
            0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 7, 7,
            7, 8, 8, 8, 9, 9, 9, 10, 10, 10, 11, 11, 11, 12, 12, 12, 13, 13, 14,
            14, 14, 15, 15, 15, 16, 16, 16, 17, 17, 17, 18, 18, 18, 19, 19, 19,
            20, 20, 21, 21, 21, 22, 22, 22, 23, 23, 23, 24, 24, 24, 25, 25, 25,
            26, 26, 26, 27, 27, 28, 28, 28, 29, 29, 29, 30, 30, 30, 31, 31, 31,
            32, 32, 32, 33, 33, 33, 34, 34, 35, 35, 35, 36, 36, 36, 37, 37, 37,
            38, 38, 38, 39, 39, 39, 40, 40, 40, 41, 41, 42, 42, 42, 43, 43, 43,
            44, 44, 44, 45, 45, 45, 46, 46, 46, 47, 47, 47, 48, 48, 49, 49, 49,
            50, 50, 50, 51, 51, 51, 52, 52, 52, 53, 53, 53, 54, 54, 54, 55, 55,
            56, 56, 56, 57, 57, 57, 58, 58, 58, 59, 59, 59, 60, 60, 60, 61, 61,
            61, 62, 62, 63, 63, 63, 64, 64, 64, 65, 65, 65, 66, 66, 66, 67, 67,
            67, 68, 68, 68, 69, 69, 70, 70, 70, 71, 71, 71, 72, 72, 72, 73, 73,
            73, 74, 74, 74, 75, 75, 75, 76, 76, 77, 77, 77, 78, 78, 78, 79, 79,
            79, 80, 80, 80, 81, 81, 81, 82, 82, 82, 83, 83, 84, 84, 84, 85, 85,
            85, 86, 86, 86, 87, 87, 87, 88, 88, 88, 89
        },
        {},
        {},
        {},
        {},
        {},
        {},
        {},
        {
            0, 0, 0, 1, 1, 2, 2, 2, 3, 3, 4, 4, 4, 5, 5, 6, 6, 6, 7, 7, 8, 8, 8,
            9, 9, 10, 10, 10, 11, 11, 12, 12, 12, 13, 13, 14, 14, 14, 15, 15,
            16, 16, 16, 17, 17, 18, 18, 18, 19, 19, 20, 20, 20, 21, 21, 22, 22,
            22, 23, 23, 24, 24, 24, 25, 25, 26, 26, 26, 27, 27, 28, 28, 28, 29,
            29, 30, 30, 30, 31, 31, 32, 32, 32, 33, 33, 34, 34, 34, 35, 35, 36,
            36, 36, 37, 37, 38, 38, 38, 39, 39, 40, 40, 40, 41, 41, 42, 42, 42,
            43, 43, 44, 44, 44, 45, 45, 46, 46, 46, 47, 47, 48, 48, 48, 49, 49,
            50, 50, 50, 51, 51, 52, 52, 52, 53, 53, 54, 54, 54, 55, 55, 56, 56,
            56, 57, 57, 58, 58, 58, 59, 59, 60, 60, 60, 61, 61, 62, 62, 62, 63,
            63, 64, 64, 64, 65, 65, 66, 66, 66, 67, 67, 68, 68, 68, 69, 69, 70,
            70, 70, 71, 71, 72, 72, 72, 73, 73, 74, 74, 74, 75, 75, 76, 76, 76,
            77, 77, 78, 78, 78, 79, 79, 80, 80, 80, 81, 81, 82, 82, 82, 83, 83,
            84, 84, 84, 85, 85, 86, 86, 86, 87, 87, 88, 88, 88, 89, 89, 90, 90,
            90, 91, 91, 92, 92, 92, 93, 93, 94, 94, 94, 95, 95, 96, 96, 96, 97,
            97, 98, 98, 98, 99, 99, 100, 100, 100, 101, 101, 102
        },
        {
            0, 0, 0, 1, 1, 2, 2, 2, 3, 3, 4, 4, 4, 5, 5, 6, 6, 6, 7, 7, 8, 8, 8,
            9, 9, 10, 10, 10, 11, 11, 12, 12, 13, 13, 13, 14, 14, 15, 15, 15,
            16, 16, 17, 17, 17, 18, 18, 19, 19, 19, 20, 20, 21, 21, 21, 22, 22,
            23, 23, 23, 24, 24, 25, 25, 26, 26, 26, 27, 27, 28, 28, 28, 29, 29,
            30, 30, 30, 31, 31, 32, 32, 32, 33, 33, 34, 34, 34, 35, 35, 36, 36,
            36, 37, 37, 38, 38, 39, 39, 39, 40, 40, 41, 41, 41, 42, 42, 43, 43,
            43, 44, 44, 45, 45, 45, 46, 46, 47, 47, 47, 48, 48, 49, 49, 49, 50,
            50, 51, 51, 52, 52, 52, 53, 53, 54, 54, 54, 55, 55, 56, 56, 56, 57,
            57, 58, 58, 58, 59, 59, 60, 60, 60, 61, 61, 62, 62, 62, 63, 63, 64,
            64, 65, 65, 65, 66, 66, 67, 67, 67, 68, 68, 69, 69, 69, 70, 70, 71,
            71, 71, 72, 72, 73, 73, 73, 74, 74, 75, 75, 75, 76, 76, 77, 77, 78,
            78, 78, 79, 79, 80, 80, 80, 81, 81, 82, 82, 82, 83, 83, 84, 84, 84,
            85, 85, 86, 86, 86, 87, 87, 88, 88, 88, 89, 89, 90, 90, 91, 91, 91,
            92, 92, 93, 93, 93, 94, 94, 95, 95, 95, 96, 96, 97, 97, 97, 98, 98,
            99, 99, 99, 100, 100, 101, 101, 101, 102, 102, 103, 103
        },
        {},
        {
            0, 0, 0, 1, 1, 2, 2, 2, 3, 3, 4, 4, 5, 5, 5, 6, 6, 7, 7, 7, 8, 8, 9,
            9, 10, 10, 10, 11, 11, 12, 12, 12, 13, 13, 14, 14, 15, 15, 15, 16,
            16, 17, 17, 18, 18, 18, 19, 19, 20, 20, 20, 21, 21, 22, 22, 23, 23,
            23, 24, 24, 25, 25, 25, 26, 26, 27, 27, 28, 28, 28, 29, 29, 30, 30,
            30, 31, 31, 32, 32, 33, 33, 33, 34, 34, 35, 35, 36, 36, 36, 37, 37,
            38, 38, 38, 39, 39, 40, 40, 41, 41, 41, 42, 42, 43, 43, 43, 44, 44,
            45, 45, 46, 46, 46, 47, 47, 48, 48, 48, 49, 49, 50, 50, 51, 51, 51,
            52, 52, 53, 53, 54, 54, 54, 55, 55, 56, 56, 56, 57, 57, 58, 58,
            59, 59, 59, 60, 60, 61, 61, 61, 62, 62, 63, 63, 64, 64, 64, 65, 65,
            66, 66, 67, 67, 67, 68, 68, 69, 69, 69, 70, 70, 71, 71, 72, 72, 72,
            73, 73, 74, 74, 74, 75, 75, 76, 76, 77, 77, 77, 78, 78, 79, 79, 79,
            80, 80, 81, 81, 82, 82, 82, 83, 83, 84, 84, 85, 85, 85, 86, 86, 87,
            87, 87, 88, 88, 89, 89, 90, 90, 90, 91, 91, 92, 92, 92, 93, 93, 94,
            94, 95, 95, 95, 96, 96, 97, 97, 97, 98, 98, 99, 99, 100, 100, 100,
            101, 101, 102, 102, 103, 103, 103, 104, 104, 105, 105, 105, 106, 106
        },
        {},
        {
            0, 0, 0, 1, 1, 2, 2, 3, 3, 3, 4, 4, 5, 5, 6, 6, 6, 7, 7, 8, 8, 9, 9,
            9, 10, 10, 11, 11, 12, 12, 12, 13, 13, 14, 14, 15, 15, 15, 16, 16,
            17, 17, 18, 18, 18, 19, 19, 20, 20, 21, 21, 21, 22, 22, 23, 23, 24,
            24, 25, 25, 25, 26, 26, 27, 27, 28, 28, 28, 29, 29, 30, 30, 31, 31,
            31, 32, 32, 33, 33, 34, 34, 34, 35, 35, 36, 36, 37, 37, 37, 38, 38,
            39, 39, 40, 40, 40, 41, 41, 42, 42, 43, 43, 43, 44, 44, 45, 45, 46,
            46, 47, 47, 47, 48, 48, 49, 49, 50, 50, 50, 51, 51, 52, 52, 53, 53,
            53, 54, 54, 55, 55, 56, 56, 56, 57, 57, 58, 58, 59, 59, 59, 60, 60,
            61, 61, 62, 62, 62, 63, 63, 64, 64, 65, 65, 65, 66, 66, 67, 67, 68,
            68, 69, 69, 69, 70, 70, 71, 71, 72, 72, 72, 73, 73, 74, 74, 75, 75,
            75, 76, 76, 77, 77, 78, 78, 78, 79, 79, 80, 80, 81, 81, 81, 82, 82,
            83, 83, 84, 84, 84, 85, 85, 86, 86, 87, 87, 87, 88, 88, 89, 89, 90,
            90, 90, 91, 91, 92, 92, 93, 93, 94, 94, 94, 95, 95, 96, 96, 97, 97,
            97, 98, 98, 99, 99, 100, 100, 100, 101, 101, 102, 102, 103, 103,
            103, 104, 104, 105, 105, 106, 106, 106, 107, 107, 108, 108, 109,
            109, 109
        },
        {
            0, 0, 0, 1, 1, 2, 2, 3, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 7, 8, 8, 9, 9,
            10, 10, 10, 11, 11, 12, 12, 13, 13, 14, 14, 14, 15, 15, 16, 16, 17,
            17, 17, 18, 18, 19, 19, 20, 20, 21, 21, 21, 22, 22, 23, 23, 24, 24,
            24, 25, 25, 26, 26, 27, 27, 28, 28, 28, 29, 29, 30, 30, 31, 31, 31,
            32, 32, 33, 33, 34, 34, 35, 35, 35, 36, 36, 37, 37, 38, 38, 38, 39,
            39, 40, 40, 41, 41, 42, 42, 42, 43, 43, 44, 44, 45, 45, 45, 46, 46,
            47, 47, 48, 48, 49, 49, 49, 50, 50, 51, 51, 52, 52, 52, 53, 53, 54,
            54, 55, 55, 56, 56, 56, 57, 57, 58, 58, 59, 59, 59, 60, 60, 61, 61,
            62, 62, 63, 63, 63, 64, 64, 65, 65, 66, 66, 66, 67, 67, 68, 68, 69,
            69, 70, 70, 70, 71, 71, 72, 72, 73, 73, 73, 74, 74, 75, 75, 76, 76,
            77, 77, 77, 78, 78, 79, 79, 80, 80, 80, 81, 81, 82, 82, 83, 83, 84,
            84, 84, 85, 85, 86, 86, 87, 87, 87, 88, 88, 89, 89, 90, 90, 91, 91,
            91, 92, 92, 93, 93, 94, 94, 94, 95, 95, 96, 96, 97, 97, 98, 98, 98,
            99, 99, 100, 100, 101, 101, 101, 102, 102, 103, 103, 104, 104, 105,
            105, 105, 106, 106, 107, 107, 108, 108, 108, 109, 109, 110, 110,
            111, 111
        },
        {},
        {},
        {},
        {
            0, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 6, 7, 7, 8, 8, 9, 9,
            10, 10, 11, 11, 12, 12, 12, 13, 13, 14, 14, 15, 15, 16, 16, 17, 17,
            18, 18, 18, 19, 19, 20, 20, 21, 21, 22, 22, 23, 23, 24, 24, 24, 25,
            25, 26, 26, 27, 27, 28, 28, 29, 29, 30, 30, 30, 31, 31, 32, 32, 33,
            33, 34, 34, 35, 35, 36, 36, 37, 37, 37, 38, 38, 39, 39, 40, 40, 41,
            41, 42, 42, 43, 43, 43, 44, 44, 45, 45, 46, 46, 47, 47, 48, 48, 49,
            49, 49, 50, 50, 51, 51, 52, 52, 53, 53, 54, 54, 55, 55, 55, 56, 56,
            57, 57, 58, 58, 59, 59, 60, 60, 61, 61, 61, 62, 62, 63, 63, 64, 64,
            65, 65, 66, 66, 67, 67, 67, 68, 68, 69, 69, 70, 70, 71, 71, 72, 72,
            73, 73, 74, 74, 74, 75, 75, 76, 76, 77, 77, 78, 78, 79, 79, 80, 80,
            80, 81, 81, 82, 82, 83, 83, 84, 84, 85, 85, 86, 86, 86, 87, 87, 88,
            88, 89, 89, 90, 90, 91, 91, 92, 92, 92, 93, 93, 94, 94, 95, 95, 96,
            96, 97, 97, 98, 98, 98, 99, 99, 100, 100, 101, 101, 102, 102, 103,
            103, 104, 104, 104, 105, 105, 106, 106, 107, 107, 108, 108, 109,
            109, 110, 110, 111, 111, 111, 112, 112, 113, 113, 114, 114, 115,
            115, 116, 116, 117, 117, 117
        },
        {},
        {},
        {
            0, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 10,
            10, 11, 11, 12, 12, 12, 13, 13, 14, 14, 15, 15, 16, 16, 17, 17, 18,
            18, 19, 19, 20, 20, 21, 21, 22, 22, 23, 23, 24, 24, 25, 25, 25, 26,
            26, 27, 27, 28, 28, 29, 29, 30, 30, 31, 31, 32, 32, 33, 33, 34, 34,
            35, 35, 36, 36, 37, 37, 38, 38, 38, 39, 39, 40, 40, 41, 41, 42, 42,
            43, 43, 44, 44, 45, 45, 46, 46, 47, 47, 48, 48, 49, 49, 50, 50, 51,
            51, 51, 52, 52, 53, 53, 54, 54, 55, 55, 56, 56, 57, 57, 58, 58, 59,
            59, 60, 60, 61, 61, 62, 62, 63, 63, 64, 64, 64, 65, 65, 66, 66, 67,
            67, 68, 68, 69, 69, 70, 70, 71, 71, 72, 72, 73, 73, 74, 74, 75, 75,
            76, 76, 77, 77, 77, 78, 78, 79, 79, 80, 80, 81, 81, 82, 82, 83, 83,
            84, 84, 85, 85, 86, 86, 87, 87, 88, 88, 89, 89, 89, 90, 90, 91, 91,
            92, 92, 93, 93, 94, 94, 95, 95, 96, 96, 97, 97, 98, 98, 99, 99, 100,
            100, 101, 101, 102, 102, 102, 103, 103, 104, 104, 105, 105, 106,
            106, 107, 107, 108, 108, 109, 109, 110, 110, 111, 111, 112, 112,
            113, 113, 114, 114, 115, 115, 115, 116, 116, 117, 117, 118, 118,
            119, 119, 120, 120, 121, 121, 122, 122
        },
        {
            0, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 10,
            10, 11, 11, 12, 12, 13, 13, 14, 14, 15, 15, 16, 16, 17, 17, 18, 18,
            19, 19, 19, 20, 20, 21, 21, 22, 22, 23, 23, 24, 24, 25, 25, 26, 26,
            27, 27, 28, 28, 29, 29, 30, 30, 31, 31, 32, 32, 33, 33, 34, 34, 35,
            35, 36, 36, 37, 37, 38, 38, 39, 39, 39, 40, 40, 41, 41, 42, 42, 43,
            43, 44, 44, 45, 45, 46, 46, 47, 47, 48, 48, 49, 49, 50, 50, 51, 51,
            52, 52, 53, 53, 54, 54, 55, 55, 56, 56, 57, 57, 58, 58, 58, 59, 59,
            60, 60, 61, 61, 62, 62, 63, 63, 64, 64, 65, 65, 66, 66, 67, 67, 68,
            68, 69, 69, 70, 70, 71, 71, 72, 72, 73, 73, 74, 74, 75, 75, 76, 76,
            77, 77, 78, 78, 78, 79, 79, 80, 80, 81, 81, 82, 82, 83, 83, 84, 84,
            85, 85, 86, 86, 87, 87, 88, 88, 89, 89, 90, 90, 91, 91, 92, 92, 93,
            93, 94, 94, 95, 95, 96, 96, 97, 97, 97, 98, 98, 99, 99, 100, 100,
            101, 101, 102, 102, 103, 103, 104, 104, 105, 105, 106, 106, 107,
            107, 108, 108, 109, 109, 110, 110, 111, 111, 112, 112, 113, 113,
            114, 114, 115, 115, 116, 116, 117, 117, 117, 118, 118, 119, 119,
            120, 120, 121, 121, 122, 122, 123, 123, 124
        },
        {
            0, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 10,
            10, 11, 11, 12, 12, 13, 13, 14, 14, 15, 15, 16, 16, 17, 17, 18, 18,
            19, 19, 20, 20, 21, 21, 22, 22, 23, 23, 24, 24, 25, 25, 26, 26, 27,
            27, 28, 28, 29, 29, 30, 30, 31, 31, 32, 32, 33, 33, 34, 34, 35, 35,
            36, 36, 37, 37, 38, 38, 39, 39, 39, 40, 40, 41, 41, 42, 42, 43, 43,
            44, 44, 45, 45, 46, 46, 47, 47, 48, 48, 49, 49, 50, 50, 51, 51, 52,
            52, 53, 53, 54, 54, 55, 55, 56, 56, 57, 57, 58, 58, 59, 59, 60, 60,
            61, 61, 62, 62, 63, 63, 64, 64, 65, 65, 66, 66, 67, 67, 68, 68, 69,
            69, 70, 70, 71, 71, 72, 72, 73, 73, 74, 74, 75, 75, 76, 76, 77, 77,
            78, 78, 79, 79, 79, 80, 80, 81, 81, 82, 82, 83, 83, 84, 84, 85, 85,
            86, 86, 87, 87, 88, 88, 89, 89, 90, 90, 91, 91, 92, 92, 93, 93, 94,
            94, 95, 95, 96, 96, 97, 97, 98, 98, 99, 99, 100, 100, 101, 101, 102,
            102, 103, 103, 104, 104, 105, 105, 106, 106, 107, 107, 108, 108,
            109, 109, 110, 110, 111, 111, 112, 112, 113, 113, 114, 114, 115,
            115, 116, 116, 117, 117, 118, 118, 118, 119, 119, 120, 120, 121,
            121, 122, 122, 123, 123, 124, 124, 125, 125
        },
        {},
        {},
        {},
        {
            0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 10, 10,
            11, 11, 12, 12, 13, 14, 14, 15, 15, 16, 16, 17, 17, 18, 18, 19, 19,
            20, 20, 21, 21, 22, 22, 23, 23, 24, 24, 25, 25, 26, 26, 27, 28, 28,
            29, 29, 30, 30, 31, 31, 32, 32, 33, 33, 34, 34, 35, 35, 36, 36, 37,
            37, 38, 38, 39, 39, 40, 40, 41, 42, 42, 43, 43, 44, 44, 45, 45, 46,
            46, 47, 47, 48, 48, 49, 49, 50, 50, 51, 51, 52, 52, 53, 53, 54, 54,
            55, 56, 56, 57, 57, 58, 58, 59, 59, 60, 60, 61, 61, 62, 62, 63, 63,
            64, 64, 65, 65, 66, 66, 67, 67, 68, 68, 69, 70, 70, 71, 71, 72, 72,
            73, 73, 74, 74, 75, 75, 76, 76, 77, 77, 78, 78, 79, 79, 80, 80, 81,
            81, 82, 83, 83, 84, 84, 85, 85, 86, 86, 87, 87, 88, 88, 89, 89, 90,
            90, 91, 91, 92, 92, 93, 93, 94, 94, 95, 95, 96, 97, 97, 98, 98, 99,
            99, 100, 100, 101, 101, 102, 102, 103, 103, 104, 104, 105, 105, 106,
            106, 107, 107, 108, 108, 109, 109, 110, 111, 111, 112, 112, 113,
            113, 114, 114, 115, 115, 116, 116, 117, 117, 118, 118, 119, 119,
            120, 120, 121, 121, 122, 122, 123, 123, 124, 125, 125, 126, 126,
            127, 127, 128, 128, 129, 129, 130, 130, 131, 131, 132
        },
        {},
        {},
        {},
        {},
        {},
        {},
        {},
        {},
        {
            0, 0, 1, 1, 2, 2, 3, 4, 4, 5, 5, 6, 6, 7, 8, 8, 9, 9, 10, 10, 11,
            12, 12, 13, 13, 14, 14, 15, 16, 16, 17, 17, 18, 18, 19, 20, 20, 21,
            21, 22, 23, 23, 24, 24, 25, 25, 26, 27, 27, 28, 28, 29, 29, 30, 31,
            31, 32, 32, 33, 33, 34, 35, 35, 36, 36, 37, 37, 38, 39, 39, 40, 40,
            41, 41, 42, 43, 43, 44, 44, 45, 46, 46, 47, 47, 48, 48, 49, 50, 50,
            51, 51, 52, 52, 53, 54, 54, 55, 55, 56, 56, 57, 58, 58, 59, 59, 60,
            60, 61, 62, 62, 63, 63, 64, 64, 65, 66, 66, 67, 67, 68, 69, 69, 70,
            70, 71, 71, 72, 73, 73, 74, 74, 75, 75, 76, 77, 77, 78, 78, 79, 79,
            80, 81, 81, 82, 82, 83, 83, 84, 85, 85, 86, 86, 87, 87, 88, 89, 89,
            90, 90, 91, 92, 92, 93, 93, 94, 94, 95, 96, 96, 97, 97, 98, 98, 99,
            100, 100, 101, 101, 102, 102, 103, 104, 104, 105, 105, 106, 106,
            107, 108, 108, 109, 109, 110, 110, 111, 112, 112, 113, 113, 114,
            115, 115, 116, 116, 117, 117, 118, 119, 119, 120, 120, 121, 121,
            122, 123, 123, 124, 124, 125, 125, 126, 127, 127, 128, 128, 129,
            129, 130, 131, 131, 132, 132, 133, 133, 134, 135, 135, 136, 136,
            137, 138, 138, 139, 139, 140, 140, 141, 142, 142, 143, 143, 144,
            144, 145, 146, 146
        },
        {},
        {},
        {},
        {},
        {},
        {},
        {
            0, 0, 1, 1, 2, 3, 3, 4, 4, 5, 6, 6, 7, 8, 8, 9, 9, 10, 11, 11, 12,
            12, 13, 14, 14, 15, 16, 16, 17, 17, 18, 19, 19, 20, 21, 21, 22, 22,
            23, 24, 24, 25, 25, 26, 27, 27, 28, 29, 29, 30, 30, 31, 32, 32, 33,
            34, 34, 35, 35, 36, 37, 37, 38, 38, 39, 40, 40, 41, 42, 42, 43, 43,
            44, 45, 45, 46, 47, 47, 48, 48, 49, 50, 50, 51, 51, 52, 53, 53, 54,
            55, 55, 56, 56, 57, 58, 58, 59, 60, 60, 61, 61, 62, 63, 63, 64, 64,
            65, 66, 66, 67, 68, 68, 69, 69, 70, 71, 71, 72, 73, 73, 74, 74, 75,
            76, 76, 77, 77, 78, 79, 79, 80, 81, 81, 82, 82, 83, 84, 84, 85, 86,
            86, 87, 87, 88, 89, 89, 90, 90, 91, 92, 92, 93, 94, 94, 95, 95, 96,
            97, 97, 98, 99, 99, 100, 100, 101, 102, 102, 103, 103, 104, 105,
            105, 106, 107, 107, 108, 108, 109, 110, 110, 111, 111, 112, 113,
            113, 114, 115, 115, 116, 116, 117, 118, 118, 119, 120, 120, 121,
            121, 122, 123, 123, 124, 124, 125, 126, 126, 127, 128, 128, 129,
            129, 130, 131, 131, 132, 133, 133, 134, 134, 135, 136, 136, 137,
            137, 138, 139, 139, 140, 141, 141, 142, 142, 143, 144, 144, 145,
            146, 146, 147, 147, 148, 149, 149, 150, 150, 151, 152, 152, 153,
            154, 154, 155, 155, 156, 157, 157
        },
        {},
        {},
        {},
        {},
        {},
        {
            0, 0, 1, 1, 2, 3, 3, 4, 5, 5, 6, 7, 7, 8, 9, 9, 10, 11, 11, 12, 13,
            13, 14, 15, 15, 16, 17, 17, 18, 19, 19, 20, 21, 21, 22, 22, 23, 24,
            24, 25, 26, 26, 27, 28, 28, 29, 30, 30, 31, 32, 32, 33, 34, 34, 35,
            36, 36, 37, 38, 38, 39, 40, 40, 41, 42, 42, 43, 43, 44, 45, 45, 46,
            47, 47, 48, 49, 49, 50, 51, 51, 52, 53, 53, 54, 55, 55, 56, 57, 57,
            58, 59, 59, 60, 61, 61, 62, 63, 63, 64, 64, 65, 66, 66, 67, 68, 68,
            69, 70, 70, 71, 72, 72, 73, 74, 74, 75, 76, 76, 77, 78, 78, 79, 80,
            80, 81, 82, 82, 83, 84, 84, 85, 85, 86, 87, 87, 88, 89, 89, 90, 91,
            91, 92, 93, 93, 94, 95, 95, 96, 97, 97, 98, 99, 99, 100, 101, 101,
            102, 103, 103, 104, 105, 105, 106, 106, 107, 108, 108, 109, 110,
            110, 111, 112, 112, 113, 114, 114, 115, 116, 116, 117, 118, 118,
            119, 120, 120, 121, 122, 122, 123, 124, 124, 125, 126, 126, 127,
            127, 128, 129, 129, 130, 131, 131, 132, 133, 133, 134, 135, 135,
            136, 137, 137, 138, 139, 139, 140, 141, 141, 142, 143, 143, 144,
            145, 145, 146, 147, 147, 148, 148, 149, 150, 150, 151, 152, 152,
            153, 154, 154, 155, 156, 156, 157, 158, 158, 159, 160, 160, 161,
            162, 162, 163, 164, 164, 165, 166, 166, 167
        },
        {},
        {},
        {},
        {},
        {},
        {},
        {},
        {},
        {
            0, 0, 1, 2, 2, 3, 4, 4, 5, 6, 7, 7, 8, 9, 9, 10, 11, 12, 12, 13, 14,
            14, 15, 16, 17, 17, 18, 19, 19, 20, 21, 22, 22, 23, 24, 24, 25, 26,
            27, 27, 28, 29, 29, 30, 31, 32, 32, 33, 34, 34, 35, 36, 37, 37, 38,
            39, 39, 40, 41, 42, 42, 43, 44, 44, 45, 46, 47, 47, 48, 49, 49, 50,
            51, 52, 52, 53, 54, 54, 55, 56, 57, 57, 58, 59, 59, 60, 61, 61, 62,
            63, 64, 64, 65, 66, 66, 67, 68, 69, 69, 70, 71, 71, 72, 73, 74, 74,
            75, 76, 76, 77, 78, 79, 79, 80, 81, 81, 82, 83, 84, 84, 85, 86, 86,
            87, 88, 89, 89, 90, 91, 91, 92, 93, 94, 94, 95, 96, 96, 97, 98, 99,
            99, 100, 101, 101, 102, 103, 104, 104, 105, 106, 106, 107, 108, 109,
            109, 110, 111, 111, 112, 113, 114, 114, 115, 116, 116, 117, 118,
            118, 119, 120, 121, 121, 122, 123, 123, 124, 125, 126, 126, 127,
            128, 128, 129, 130, 131, 131, 132, 133, 133, 134, 135, 136, 136,
            137, 138, 138, 139, 140, 141, 141, 142, 143, 143, 144, 145, 146,
            146, 147, 148, 148, 149, 150, 151, 151, 152, 153, 153, 154, 155,
            156, 156, 157, 158, 158, 159, 160, 161, 161, 162, 163, 163, 164,
            165, 166, 166, 167, 168, 168, 169, 170, 171, 171, 172, 173, 173,
            174, 175, 175, 176, 177, 178, 178, 179, 180, 180, 181
        },
        {
            0, 0, 1, 2, 2, 3, 4, 5, 5, 6, 7, 7, 8, 9, 10, 10, 11, 12, 12, 13,
            14, 15, 15, 16, 17, 17, 18, 19, 20, 20, 21, 22, 22, 23, 24, 25, 25,
            26, 27, 28, 28, 29, 30, 30, 31, 32, 33, 33, 34, 35, 35, 36, 37, 38,
            38, 39, 40, 40, 41, 42, 43, 43, 44, 45, 46, 46, 47, 48, 48, 49, 50,
            51, 51, 52, 53, 53, 54, 55, 56, 56, 57, 58, 58, 59, 60, 61, 61, 62,
            63, 63, 64, 65, 66, 66, 67, 68, 68, 69, 70, 71, 71, 72, 73, 74, 74,
            75, 76, 76, 77, 78, 79, 79, 80, 81, 81, 82, 83, 84, 84, 85, 86, 86,
            87, 88, 89, 89, 90, 91, 91, 92, 93, 94, 94, 95, 96, 97, 97, 98, 99,
            99, 100, 101, 102, 102, 103, 104, 104, 105, 106, 107, 107, 108, 109,
            109, 110, 111, 112, 112, 113, 114, 115, 115, 116, 117, 117, 118,
            119, 120, 120, 121, 122, 122, 123, 124, 125, 125, 126, 127, 127,
            128, 129, 130, 130, 131, 132, 132, 133, 134, 135, 135, 136, 137,
            138, 138, 139, 140, 140, 141, 142, 143, 143, 144, 145, 145, 146,
            147, 148, 148, 149, 150, 150, 151, 152, 153, 153, 154, 155, 155,
            156, 157, 158, 158, 159, 160, 161, 161, 162, 163, 163, 164, 165,
            166, 166, 167, 168, 168, 169, 170, 171, 171, 172, 173, 173, 174,
            175, 176, 176, 177, 178, 178, 179, 180, 181, 181, 182, 183
        },
        {},
        {},
        {},
        {},
        {},
        {},
        {},
        {},
        {},
        {},
        {},
        {},
        {},
        {},
        {},
        {},
        {},
        {},
        {},
        {},
        {},
        {},
        {},
        {},
        {},
        {},
        {},
        {},
        {},
        {},
        {},
        {},
        {
            0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 12, 13, 14, 15, 16, 17,
            18, 19, 20, 21, 22, 23, 24, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33,
            34, 35, 36, 37, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49,
            49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 61, 62, 63, 64,
            65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 74, 75, 76, 77, 78, 79, 80,
            81, 82, 83, 84, 85, 86, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96,
            97, 98, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109,
            110, 111, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121,
            122, 123, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133,
            134, 135, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144, 145,
            146, 147, 148, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157,
            158, 159, 160, 160, 161, 162, 163, 164, 165, 166, 167, 168, 169,
            170, 171, 172, 172, 173, 174, 175, 176, 177, 178, 179, 180, 181,
            182, 183, 184, 185, 185, 186, 187, 188, 189, 190, 191, 192, 193,
            194, 195, 196, 197, 197, 198, 199, 200, 201, 202, 203, 204, 205,
            206, 207, 208, 209, 209, 210, 211, 212, 213, 214, 215, 216, 217,
            218, 219, 220, 221, 222, 222, 223, 224, 225, 226, 227, 228, 229,
            230, 231, 232, 233, 234, 234, 235
        }
    };

    private final GenericValue<Boolean> link;
    private final GenericValue<Double> size;

    public ReverbSpredValue(final String name, final GenericValue<Boolean> link, final GenericValue<Double> size) {
        super(name, "", 0, 255);
        this.link = link;
        this.size = size;
    }

    @Override
    public String getDisplayString() {
        String spred;
        if (link.getValue()) {
            int sizeIndex = (int) ((size.getValue() - 4) * 2);
            spred = Integer.toString(REVERB_SPRED[sizeIndex][getValue()]);
        } else {
            spred = Integer.toString(getValue());
        }
        return spred;
    }

}
